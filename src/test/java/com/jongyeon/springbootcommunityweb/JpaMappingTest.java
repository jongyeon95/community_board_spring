package com.jongyeon.springbootcommunityweb;

import com.jongyeon.springbootcommunityweb.web.domain.Board;
import com.jongyeon.springbootcommunityweb.web.domain.User;
import com.jongyeon.springbootcommunityweb.web.domain.enums.BoardType;
import com.jongyeon.springbootcommunityweb.web.repository.BoardRepository;
import com.jongyeon.springbootcommunityweb.web.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import javax.persistence.Table;
import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {
    private final String boardTestTitle="테스트";
    private final String email="test@gmail.com";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Before
    public void init(){
        User user=userRepository.save(User.builder()
                .name("jy")
                .password("test")
                .email(email)
                .createdDate(LocalDateTime.now())
                .build());

        boardRepository.save(Board.builder()
                .title(boardTestTitle)
                .subTitle("서브타이틀")
                .content("콘텐트")
                .boardType(BoardType.free)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .user(user)
                .build());
    }

    @Test
    public void 제대로_생성되었는지_테스트(){
        User user=userRepository.findByEmail(email);
        assertThat(user.getName(),is("jy"));
        assertThat(user.getPassword(),is("test"));
        assertThat(user.getEmail(),is(email));

        Board board=boardRepository.findByUser(user);
        assertThat(board.getTitle(),is(boardTestTitle));
        assertThat(board.getSubTitle(),is("서브타이틀"));
        assertThat(board.getContent(),is("콘텐트"));
        assertThat(board.getBoardType(),is(BoardType.free));
    }
}
