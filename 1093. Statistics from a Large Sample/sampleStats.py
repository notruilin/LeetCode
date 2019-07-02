class Solution(object):
    def sampleStats(self, count):
        """
        :type count: List[int]
        :rtype: List[float]
        """
        total_sum, minv, maxv, maxcount, mode, now_count = 0, -1, -1, -1, -1, 0
        median_x, median_y = -1, -1
        total_count = sum(count)
        for i in range(256):
            if count[i] > 0:
                if minv == -1: minv = i
                maxv = i
                total_sum += i * count[i]
                if count[i] > maxcount:
                    maxcount = count[i]
                    mode = i
                if now_count < total_count / 2 and now_count + count[i] >= total_count / 2:
                    median_x = i
                if now_count < total_count / 2 + 1 and now_count + count[i] >= total_count / 2 + 1:
                    median_y = i
                now_count += count[i]
        mean = total_sum / (total_count * 1.0)
        if total_count % 2 == 0:
            median = (median_x + median_y) / 2.0
        else:
            median = median_y
        return [minv, maxv, mean, median, mode]
        
