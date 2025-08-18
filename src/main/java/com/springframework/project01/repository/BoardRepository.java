package com.springframework.project01.repository;

import com.springframework.project01.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    // mybatis를 쓰는 다른 방식 1) repository를 interface로 두고 추상메서드 정의 후 사용
    // 2) class에 쿼리를 바로 작성해서 xml 파일을 생성하지 않고 사용

    // mybatis에서 제공하는 클래스, java 클래스와 mapper간의 연결 역할 클래스
    private final SqlSessionTemplate sql;

    public int save(BoardDTO boardDTO) {
        // ""안의 Board는 mapper에서 작성한 namespace, .save는 그 안에 id를 넣어준 값
        /*
          두번째 파라미터는 프론트에서 값을 전달받은 값. 프론트에서 전달받는 값이 있다면 mapper에 parameter값을 적어주어야 한다.
        */
        return sql.insert("Board.save", boardDTO);
    }

    public List<BoardDTO> findAll() {
        return sql.selectList("Board.findAll");
    }

    public BoardDTO findById(Long id) {
        // 가져오는 데이터가 여러개면 List 하지만 하나만 가져오는거라면 One을 써준다
        return sql.selectOne("Board.findById", id);
    }

    public void updateHits(Long id) {
        sql.update("Board.updateHits", id);
    }

    public void delete(Long id) {
        sql.delete("Board.delete", id);
    }
}
