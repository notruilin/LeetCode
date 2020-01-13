/**
 * @param {number} n
 * @param {number[][]} connections
 * @return {number}
 */
var makeConnected = function(n, connections) {
    var visited = [];
    var map = [];

    function dfs(i) {
        visited[i] = true;
        for (var j = 0; j < map[i].length; j++) {
            if (!visited[map[i][j]])    dfs(map[i][j]);  
        }
    }
    
    if (connections.length < n-1)   return -1;
    for (var i = 0; i < n; i++) {
        visited.push(false);
        map.push([]);
    }
    for (var i = 0; i < connections.length; i++) {
        map[connections[i][0]].push(connections[i][1]);
        map[connections[i][1]].push(connections[i][0]);
    }
    var cost = 0;
    for (var i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i);
            cost += 1;
        }
    }
    return cost - 1;
};
