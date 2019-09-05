package ktds.erp.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("boarddao")
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	SqlSession sqlSession;//dao연동하는 메소드가 정의되어 있는 템플릿 클래스
	
	@Override
	public int update(BoardDTO board) {
		// TODO Auto-generated method stub
		return sqlSession.update("kr.ktds.board.update", board);
	}
	@Override
	public int delete(String board_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete("kr.ktds.board.delete", board_no);
	}
	@Override
	public int insert(BoardDTO board) {
		System.out.println("dao===>"+board);
		int result = sqlSession.insert("kr.ktds.board.insert", board);
		return result;
	}
	@Override
	public int fileInsert(ArrayList<String> filelist) {
		Map<String, Object> paramMap =
				new HashMap<String, Object>();
		paramMap.put("filelist",filelist);
		System.out.println("mybatis:"+paramMap);
		int sub = 
			sqlSession.insert("kr.ktds.board.fileinsert",paramMap);
		return sub;
	}
	@Override
	public List<BoardDTO> boardList() {
		return sqlSession.selectList("kr.ktds.board.listall");
	}

	@Override
	public List<BoardDTO> categorySearch(String category){
		return sqlSession.selectList("kr.ktds.board.category",category);
	}

	@Override
	public List<BoardDTO> dynamicSearch(String tag, String search) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tag",tag);
		map.put("search",search);
		return sqlSession.selectList("kr.ktds.board.dynamicsearch", map) ;
	}

	@Override
	public List<BoardDTO> pageList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BoardDTO read(String board_no) {
		return sqlSession.selectOne("kr.ktds.board.read", board_no);
	}
	

	

}
