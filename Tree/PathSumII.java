public List<List<Integer>> pathSum(TreeNode root, int sum) {
	List<List<Integer>> result  = new LinkedList<>();
	pathSum(root, sum, new LinkedList<>(), result);
	return result;
}

private void pathSum(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
	if (root == null)
		return;
	list.add(root.val);
	if (root.left == null && root.right == null && sum == root.val) {
		result.add(new LinkedList(list));
	} else {
		pathSum(root.left, sum - root.val, list, result);
		pathSum(root.right, sum - root.val, list, result);
	}
	list.remove(list.size() - 1);
}