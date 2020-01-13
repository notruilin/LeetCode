/**
 * @param {string} word
 * @return {number}
 */
var minimumDistance = function(word) {
    function pos(a) {
        var x = Math.floor(charToNum(a) / 6);
        var y = charToNum(a) % 6;
        return [x, y];
    }
    
    function dis(a, b) {
        var pos1 = pos(a);
        var pos2 = pos(b);
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
    
    function numToChar(num) {
        return String.fromCharCode(num + 'A'.charCodeAt(0));
    }
    
    function charToNum(c) {
        return c.charCodeAt(0) - 'A'.charCodeAt(0);
    }
    
    var f = new Array(word.length);
    for (var i = 0; i < f.length; i++)
        f[i] = new Array(26);
    for (var i = 0; i < word.length; i++)
        for (var j = 0; j < 26; j++) {
            f[i][j] = new Array(26);
            for (var k = 0; k < 26; k++)
                f[i][j][k] = word.length * word.length;
        }      
    
    for (var i = 0; i < 26; i++) {
        f[0][charToNum(word[0])][i] = 0;
        f[0][i][charToNum(word[0])] = 0;
    }
    for (var i = 1; i < word.length; i++)
        for (var j = 0; j < 26; j++)
            for (var k = 0; k < 26; k++) {
                f[i][charToNum(word[i])][k] = Math.min(f[i][charToNum(word[i])][k], f[i-1][j][k] + dis(numToChar(j), word[i]));
                f[i][j][charToNum(word[i])] = Math.min(f[i][j][charToNum(word[i])], f[i-1][j][k] + dis(numToChar(k), word[i]));
            }
    
    var ans = word.length * word.length;
    for (var j = 0; j < 26; j++)
        for (var k = 0; k < 26; k++)
            ans = Math.min(ans, f[word.length - 1][j][k]);
    
    return ans;
};
