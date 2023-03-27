import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution퍼즐조각채우기 {

	public static void main(String[] args) {
		int[][] game_board = { { 1, 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0, 1 }, { 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0, 0 } };

		int[][] table = { { 1, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0 } };
		Solution sol = new Solution();
		System.out.println(sol.solution(game_board, table));
	}
}

class Solution {
	private int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private int[][] tableMap;
	private int[][] boardMap;
	private ArrayList<ArrayList<Block>> puzzle;// 퍼즐
	private ArrayList<ArrayList<Block>> board;// 퍼즐을 둘 수 있는 부분
	private boolean[] boardVisited;// 이미 퍼즐이 채워진 부분을 표시
	private boolean[] puzzleVisited;// 이미 사용한 퍼즐을 표시
	private int n;//보드판의 한 변 길이
	private int answer;//반환해야하는 값

	public int solution(int[][] game_board, int[][] table) {
		puzzle = new ArrayList<ArrayList<Block>>();
		board = new ArrayList<ArrayList<Block>>();
		tableMap = table;
		boardMap = game_board;
		n = tableMap.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tableMap[i][j] == 1)
					getPuzzle(i, j);
				if (boardMap[i][j] == 0)
					getBoard(i, j);
			}
		}
		boardVisited = new boolean[board.size()];
		puzzleVisited = new boolean[puzzle.size()];
		getRes();
		getBlockCount();
		return answer;
	}

	public void getPuzzle(int startRow, int startCol) {
		Queue<Block> q = new LinkedList<Block>();
		ArrayList<Block> list = new ArrayList<Block>();
		Block startBlock = new Block(startRow, startCol);
		q.add(startBlock);
		list.add(startBlock);
		tableMap[startRow][startCol] = 0;
		while (q.isEmpty() == false) {
			Block element = q.remove();
			for (int i = 0; i < move.length; i++) {
				int nextRow = element.row + move[i][0];
				int nextCol = element.col + move[i][1];
				if (check(nextRow, nextCol, 0)) {
					Block b = new Block(nextRow, nextCol);
					tableMap[nextRow][nextCol] = 0;
					q.add(b);
					list.add(b);
				}
			}
		}
		Collections.sort(list);
		puzzle.add(list);
	}

	public void getBoard(int startRow, int startCol) {
		Queue<Block> q = new LinkedList<Block>();
		ArrayList<Block> list = new ArrayList<Block>();
		Block startBlock = new Block(startRow, startCol);
		q.add(startBlock);
		list.add(startBlock);
		boardMap[startRow][startCol] = 1;
		while (q.isEmpty() == false) {
			Block element = q.remove();
			for (int i = 0; i < move.length; i++) {
				int nextRow = element.row + move[i][0];
				int nextCol = element.col + move[i][1];
				if (check(nextRow, nextCol, 1)) {
					Block b = new Block(nextRow, nextCol);
					boardMap[nextRow][nextCol] = 1;
					q.add(b);
					list.add(b);
				}
			}
		}
		Collections.sort(list);
		board.add(list);
	}

	public void getRes() {
		for (int i = 0; i < puzzle.size(); i++) {// 퍼즐 하나 선택
			ArrayList<Block> p = puzzle.get(i);

			for (int j = 0; j < board.size(); j++) {// 퍼즐을 놓을 수 있는 게임판 하나 선택
				if (boardVisited[j] == true)//이미 퍼즐이 끼워진 판은 제외
					continue;
				ArrayList<Block> b = board.get(j);
				if (p.size() == b.size()) {//사이즈가 동일할때만 검사
					for (int r = 0; r < 4; r++) {//90도씩 회전한다
						int rowDiff = 51;//게임판 크기가 3~50이므로 어떤 row끼리 빼더라도 51은 나오지 않으므로 초기값으로 선택함
						int colDiff = 51;
						int k = 0;
						b = getRotate(b, r);//회전한 결과물
						for (; k < b.size(); k++) {
							int rowDiffNow = (p.get(k).row - b.get(k).row);
							int colDiffNow = (p.get(k).col - b.get(k).col);
							if (rowDiff == 51 && colDiff == 51) {
								rowDiff = rowDiffNow;
								colDiff = colDiffNow;
							} else if (rowDiffNow != rowDiff || colDiffNow != colDiff) {
								break;
							}
						}
						if (k == b.size()) {
                            puzzleVisited[i] = true;
							boardVisited[j] = true;
							break;
						}
					}

				}
				if (puzzleVisited[i] == true)//이미 지금 살펴보는 퍼즐을 끼웠으므로 다른 보드판은 볼 필요없음
					break;
			}

		}
	}

	public ArrayList<Block> getRotate(ArrayList<Block> list, int num) {//회전시키는 함수
		ArrayList<Block> newList;
		for (int count = 0; count < num; count++) {//for문 한번 돌때마다 90도 회전한다
			newList = new ArrayList<Block>();
			for (int i = 0; i < list.size(); i++) {
				Block b = new Block(list.get(i).col, n - 1 - list.get(i).row);
				newList.add(b);
			}
			Collections.sort(newList);//회전 후 정렬한다
			list = newList;
		}
		return list;
	}

	public void getBlockCount() {//반환해야하는 값인 블록수를 계산함
		for (int i = 0; i < puzzle.size(); i++) {
			if (puzzleVisited[i] == true) {
				answer += puzzle.get(i).size();
			}
		}
	}

	public boolean check(int row, int col, int num) {
		if (row >= n || col >= n || row < 0 || col < 0) {
			return false;
		}
		if (num == 0) {// table인 경우
			if (tableMap[row][col] == num)
				return false;
		} else {// board인 경우
			if (boardMap[row][col] == num)
				return false;
		}
		return true;
	}
}

class Block implements Comparable<Block> {
	int row;
	int col;

	public Block(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public int compareTo(Block o) {
		if (this.row == o.row) {
			return this.col - o.col;
		}
		return this.row - o.row;
	}
}