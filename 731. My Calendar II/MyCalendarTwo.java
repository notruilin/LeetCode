class MyCalendarTwo {
    
    List<int[]> overlaps;
    List<int[]> events;

    public MyCalendarTwo() {
        overlaps = new ArrayList();
        events = new ArrayList();
    }
    
    public boolean book(int start, int end) {
        for (int[] event: overlaps)
            if (start < event[1] && end > event[0]) return false;
        
        for (int[] event: events)
            if (start < event[1] && end > event[0])
                overlaps.add(new int[]{ Math.max(start, event[0]), Math.min(end, event[1]) });
        
        events.add(new int[]{ start, end });
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
