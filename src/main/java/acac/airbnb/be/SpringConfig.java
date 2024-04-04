package acac.airbnb.be;

import acac.airbnb.be.repository.JdbcMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import acac.airbnb.be.repository.MemberRepository;
import acac.airbnb.be.service.MemberService;


import javax.sql.DataSource;

@Configuration
public class SpringConfig {
//    private DataSource dataSource;
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository(){
//        return new JdbcMemberRepository(dataSource);
//    }
}
