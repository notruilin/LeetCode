public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0)   return null;
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            if (str.length() == 0)  sb.append("E");
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                sb.append((int)c);
                sb.append('#');
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s == null)  return new ArrayList();
        List<String> lst = new ArrayList();
        String[] strs = s.split(" ");
        for (String str: strs) {
            if (str.equals("E")) {
                lst.add("");
                continue;
            }
            String[] nums = str.split("#");
            StringBuilder sb = new StringBuilder();
            for (String num: nums)
                sb.append((char)Integer.parseInt(num));
            lst.add(sb.toString());
        }
        return lst;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
