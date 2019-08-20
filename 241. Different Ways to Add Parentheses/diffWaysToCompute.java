class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if (input.matches("[0-9]+"))
            return new ArrayList<Integer>(Arrays.asList(Integer.parseInt(input)));
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
                for (int x: left) {
                    for (int y: right) {
                        switch (input.charAt(i)) {
                            case '+':
                                res.add(x+y);
                                break;
                            case '-':
                                res.add(x-y);
                                break;
                            case '*':
                                res.add(x*y);
                                break;
                            default:
                                System.out.println("Error input!");
                        }
                    }
                }
            }
        }
        return res;
    }
}
