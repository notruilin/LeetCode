/**
 * @param {number} n
 * @return {number[]}
 */
var getNoZeroIntegers = function(n) {
    
    function isNoZero(x) {
        return !x.toString().includes('0');
    }
    
    for (let i = 1; i < n; i++) {
        if (isNoZero(i) && isNoZero(n-i))
            return [i, n-i];
    }
};
