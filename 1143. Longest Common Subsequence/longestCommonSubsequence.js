/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(text1, text2) {
    var f = new Array(1000);
    for (let i = 0; i < f.length; i++)
        f[i] = new Array(1000);
    for (let i = 0; i < text1.length; i++)
        for (let j = 0; j < text2.length; j++)
            f[i][j] = 0;
    for (let i = 0; i < text1.length; i++)
        for (let j = 0; j < text2.length; j++) {
            if (i - 1 >= 0) f[i][j] = f[i-1][j];
            if (j - 1 >= 0) f[i][j] = Math.max(f[i][j], f[i][j-1]);
            let tmp = 0;
            if (i - 1 >= 0 && j - 1 >= 0)   tmp = f[i-1][j-1];
            if (text1.charAt(i) == text2.charAt(j)) {
                f[i][j] = Math.max(f[i][j], tmp + 1);
            }
        }
    return f[text1.length - 1][text2.length - 1];
};
