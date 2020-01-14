/**
 * @param {number[]} nums
 * @return {number[]}
 */
var decompressRLElist = function(nums) {
    var ans = [];
    for (var i = 0; i < nums.length; i+=2) {
        for (var j = 0; j < nums[i]; j++)
            ans.push(nums[i+1]);
    }
    return ans;
};
