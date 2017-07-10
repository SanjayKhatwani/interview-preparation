public List<String> wordsAbbreviation(List<String> dict) {
    int len = dict.size();
    String[] res = new String[len];
    int[] prefix = new int[len];
    for (int i = 0; i < len; i++) {
        prefix[i] = 1;
        ans[i] = makeAbbr(dict.get(i), 1); // make abbreviation for each string
    }
    for (int i = 0; i < len; i++) {
        while (true) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < len; j++) {
                if (ans[j].equals(ans[i])) set.add(j); // check all strings with the same abbreviation
            }
            if (set.isEmpty()) break;
            set.add(i);
            for (int k : set) 
                ans[k] = makeAbbr(dict.get(k), ++prefix[k]); // increase the prefix
        }
    }
    return Arrays.asList(ans);
}

private String makeAbbr(String s, int k) {
    if (k >= s.length() - 2) return s;
    return new StringBuilder()
        .append(s.substring(0, k))
        .append(s.length() - 1 - k)
        .append(s.charAt(s.length() - 1))
        .toString();
}
