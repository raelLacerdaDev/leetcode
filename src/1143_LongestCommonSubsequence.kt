import kotlin.math.max


fun longestCommonSubsequence(text1: String, text2: String): Int {
    return maxSubsequence(text1, text2)
}

fun maxSubsequence(
    text1: String,
    text2: String,
    index1: Int = text1.lastIndex,
    index2: Int = text2.lastIndex,
    mat: Array<IntArray> = Array(text1.length) { IntArray(text2.length) { -1 } }
): Int {
    if (index1 < 0 || index2 < 0) {
        return 0
    }
    if (mat[index1][index2] != -1) {
        return mat[index1][index2]
    }

    if (text1[index1] == text2[index2]) {
        mat[index1][index2] = 1 + maxSubsequence(text1, text2, index1 - 1, index2 - 1, mat)
    } else {
        mat[index1][index2] =
            0 + max(maxSubsequence(text1, text2, index1, index2 - 1,mat), maxSubsequence(text1, text2, index1 - 1, index2,mat))
    }
    return mat[index1][index2]
}


fun main() {

    println(
        longestCommonSubsequence(text1 = "abc", text2 = "bac")
    )

}