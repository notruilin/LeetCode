class Solution {
    class Transaction {
        String name, city;
        int time, amount;
        public Transaction(String strS) {
            String[] str = strS.split(",");
            this.name = str[0];
            this.time = Integer.parseInt(str[1]);
            this.amount = Integer.parseInt(str[2]);
            this.city = str[3];
        }
    }
    
    public List<String> invalidTransactions(String[] transactions) {
        Transaction[] data = new Transaction[transactions.length];
        for (int i = 0; i < transactions.length; i++)
            data[i] = new Transaction(transactions[i]);
        List<String> ans = new ArrayList();
        for (int i = 0; i < data.length; i++) {
            if (data[i].amount > 1000) {
                ans.add(transactions[i]);
                continue;
            }
            for (int j = 0; j < data.length; j++) {
                if (i == j) continue;
                if (Math.abs(data[i].time - data[j].time) <= 60 && data[i].name.equals(data[j].name) && !data[i].city.equals(data[j].city)) {
                    ans.add(transactions[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
