public class Solution {

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) 
            return false;

        String[] nodes = preorder.split(",");
        LinkedList<String> stack = new LinkedList<>();

        for (String str : nodes) {
            stack.push(str);
            while (stack.size() >= 3 && stack.get(0).equals("#")
                    && stack.get(1).equals("#") && !stack.get(2).equals("#")) {
                        stack.pop();
                        stack.pop();
                        stack.pop();
                        stack.push("#");
                    }
        }
        
        return stack.size() == 1 && stack.peek().equals("#");
    }

}