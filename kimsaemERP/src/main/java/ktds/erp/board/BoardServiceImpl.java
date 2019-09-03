package ktds.erp.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	@Qualifier("boarddao")
	BoardDAO dao;
	@Override
	public List<BoardDTO> boardList(String category) {
		List<BoardDTO> boardlist = null;
		if(category!=null) {
			if(category.equals("all")) {
				System.out.println("all");
				boardlist = dao.boardList();
				System.out.println(boardlist);
			}else{
				boardlist = dao.categorySearch(category);
			}
		}
		return boardlist;
	}

	@Override
	public int insert(BoardDTO board,ArrayList<String> filelist) {
		int result = 0;
		int boardResult = dao.insert(board);
		int boardFileResult=0;
		if(filelist.size()!=0) {
			String testStr = null;
			testStr.length();
			boardFileResult = dao.fileInsert(filelist);
			if(boardResult>=1 & boardFileResult>=1) {
				result = 1;
			}
		}else {
			if(boardResult>=1) {
				result=1;
			}
		}
		return 0;
	}


	@Override
	public List<BoardDTO> dynamicSearch(String tag,String search) {
		// TODO Auto-generated method stub
		return dao.dynamicSearch(tag, search);
	}

	@Override
	public List<BoardDTO> pageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO read(String board_no) {
		// TODO Auto-generated method stub
		return dao.read(board_no);
	}

	@Override
	public int update(BoardDTO board) {
		// TODO Auto-generated method stub
		return dao.update(board);
	}

	@Override
	public int delete(String board_no) {
		// TODO Auto-generated method stub
		return dao.delete(board_no);
	}

	
	//트랜잭션  메소드 - 논리적인 작업단위(계좌이체,책구매,물건구매....,사원등록(가족사항,경력사항..)
	@Override
	public int txinsert(BoardDTO board) {
		dao.insert(board);//주문테이블에 insert - 주문의 일반적인 내용
		dao.insert(null);//주문상품테이블에 insert - 내가 주문한 상품의 목록
		//주문같은 경우 수량을 -1하는 메소드도 호출
		return 0;
	}

}













