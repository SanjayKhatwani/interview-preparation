/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/

public String simplifyPath(String path) {
    String[] dirNames = path.split("/");
        String[] dirNames = path.split("/");
        Deque<String> stack = new LinkedList<>();
        Set<String> skipSet = new HashSet<>(Arrays.asList(".", "..", ""));
        for (String dir: dirNames) {
            if (!skipSet.contains(dir)) stack.push(dir);
            else if ("..".equals(dir) && !stack.isEmpty()) stack.pop();
        }
        StringBuilder pathBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            pathBuilder.insert(0, "/" + stack.pop());
        }
        return pathBuilder.length() > 0 ? pathBuilder.toString() : "/";
}
