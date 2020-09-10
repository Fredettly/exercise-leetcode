import java.util.*;

public class Combination {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (k == 0 || n <= k) return res;
		Deque<Integer> path = new ArrayDeque<>();
		dfs(n, k, 1, path, res);
		return res;
	}
	private void dfs(int n, int k , int begin, Deque<Integer> path, List<List<Integer>> res) {
		if (path.size() == k) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
			path.addLast(i);
			System.out.println("before recur ... " + path);
			dfs(n, k, i + 1, path, res);
			path.removeLast();
			System.out.println("after  recur ... " + path);
		}
	}
	public static void main(String[] agrs) {
		Combination solution = new Combination();
		List<List<Integer>> res = solution.combine(6, 3);
		for (List<Integer> list : res)
			System.out.println(list);
	}
}