package util;

import java.util.List;

//앞으로 모든~~게시판에 적용할 수 있는 범용적 페이징 처리 계산 객체
public class PagingManager {
	//페이징 처리란? 데이터를 분할하여 출력하는 기법(산수 계산에 의함)
	//페이징 처리에서 가장 중요한 것 : 데이터가 있어야함.
	//페이징 처리 로직을 개발하는 과정에서는 db연동은 필수가 아니다.
	private int totalRecord;//총 레코드 수
	private int pageSize=10;//한 페이지당 보여질 레코드 수(sql에서 쓰는 명령어 : set pagesize)
	private int totalPage;//총 페이지 수
	private int blockSize=10;//블럭당 보여질 페이지 수 
	private int currentPage=1;//현재 유저가 보고 있는 페이지-무조건 첫페이지
	//사용자가 클릭할때 바뀐다.
	
	//힌트 : 위에 선언된 변수들을 조합만 하면 됨
	private int firstPage;
	private int lastPage;
	//어떤 페이지를 클릭하든 반복문은 first부터last까지 돈다
	
	private int num;
	private int curPos;//페이지당 ArrayList의 시작 위치, 
	//1페이지때는 커서를 0에 돌려놓고~ 반복문을 돌린다.(10번)
	//2페이지때는 커서를 10
	
	//페이지 수가 증가할 수록 과거의 글
		
	//페이징 처리 계산 메서드
	//필요할때마다 호출-페이지버튼을 누를때, 최초로 프로그램을 켤때
	//데이터가 갱신되어야할때마다
	public void init(List list, int currentPage) {
		totalRecord=list.size();//체크용
		//int형이라 소수점이 지원되지 않아, 소숫점 뒤의 값이 버려짐
		//int 중 하나를 실수형으로 바꿔준다.
		totalPage=(int)Math.ceil((float)totalRecord/pageSize);//pageSize은 자동 형변환됨
			
		System.out.println(totalPage);
		this.currentPage=currentPage;//사용자가 선택한 페이지를 넘겨받아서 현재 페이지로 설정
		
		firstPage=currentPage-(currentPage-1)%blockSize;//블럭당 반복문의 시작값
		lastPage=firstPage+(blockSize-1);//블럭당 끝값 시작값
		curPos=(currentPage-1)*pageSize;
		num=totalRecord-curPos;//페이지당 시작 번호
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getCurPos() {
		return curPos;
	}

	public void setCurPos(int curPos) {
		this.curPos = curPos;
	}
	
	
}
