package hello.login.web.member;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    //회원가입 폼 보여주기
    @GetMapping("/add")
    public String addForm(@ModelAttribute Member member){
        return "members/addMemberForm";
    }

    //회원가입 진행
    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult) {
        //검증 문제 발생 -> 다시 회원가입 폼으로 이동
        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }

        //검증 문제 없음 -> 회원가입 성공 -> 홈 화면으로 리다이렉트
        memberRepository.save(member);
        return "redirect:/";
    }


}
