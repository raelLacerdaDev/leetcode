import kotlin.math.max

fun main() {
    val reward = arrayOf(1 to 6, 2 to 10, 3 to 12)
    println(
        knapsackProblem(reward, 5) // 22
    )
}

fun knapsackProblem(rewards: Array<Pair<Int, Int>>, maxWeight: Int): Int {
    return choose(rewards, maxWeight)
}


//top down
private fun choose(
    rewards: Array<Pair<Int, Int>>,
    maxWeight: Int,
    currentWeight: Int = 0,
    index: Int = 0,
    memory: Array<IntArray> = Array(rewards.size) {
        IntArray(maxWeight + 1) { -1 }
    }
): Int {

    if (index > rewards.lastIndex) {
        return 0
    }

    if (currentWeight == maxWeight) {
         return 0
    }

    if(memory[index][currentWeight] != -1) {
        return memory[index][currentWeight]
    }

    if (rewards[index].first + currentWeight <= maxWeight) {
        // choose
        val maxIfChoose = choose(
            rewards = rewards,
            maxWeight = maxWeight,
            currentWeight = rewards[index].first + currentWeight,
            index = index + 1,
            memory = memory,
        )

        // dont choose
        val maxIfNotChoose = choose(
            rewards = rewards,
            maxWeight = maxWeight,
            currentWeight = currentWeight,
            index = index + 1,
            memory = memory,
        )

        memory[index][currentWeight] = max(rewards[index].second + maxIfChoose, maxIfNotChoose)

    } else {

        memory[index][currentWeight] = choose(
            rewards = rewards,
            maxWeight = maxWeight,
            currentWeight = currentWeight,
            index = index + 1,
            memory = memory,
        )

    }

    return memory[index][currentWeight]
}