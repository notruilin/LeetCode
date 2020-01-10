/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    cost.push(0);
    for (var i = 2; i < cost.length; i++) {
        cost[i] += Math.min(cost[i-1], cost[i-2]);
    }
    return cost[cost.length - 1];
};
