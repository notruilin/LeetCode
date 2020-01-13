/**
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {number}
 */
var minFlips = function(a, b, c) {
    var cost = 0;
    while (c > 0 || a > 0 || b > 0) {
        if (((a & 1) | (b & 1)) != (c & 1)) {
            cost += 1;
            if ((a & 1) == 1 && (b & 1) == 1)   cost += 1;
        }
        a >>= 1;
        b >>= 1;
        c >>= 1;
    }
    return cost;
};
