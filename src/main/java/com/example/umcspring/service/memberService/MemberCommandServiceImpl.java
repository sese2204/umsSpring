package com.example.umcspring.service.memberService;

import com.example.umcspring.converter.MemberConverter;
import com.example.umcspring.converter.MemberPreferConverter;
import com.example.umcspring.domain.FoodCategory;
import com.example.umcspring.domain.Member;
import com.example.umcspring.domain.mapping.MemberPrefer;
import com.example.umcspring.repository.FoodCategoryRepository;
import com.example.umcspring.repository.MemberRepository;
import com.example.umcspring.web.dto.MemberRequestDTO.JoinDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(JoinDto request) {
        Member newMember = MemberConverter.requestToMember(request);
        List<FoodCategory> foodCategories = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(
                            () -> new RuntimeException("Category not found")
                    );
                }).toList();

        /* For 문 사용: 예외 발생 시 어떤 category ID에서 문제가 발생했는지 디버깅이 용이함
        List<FoodCategory> foodCategoryList = new ArrayList<>();
        for (Long category : request.getPreferCategory()) {
            try {
                FoodCategory foodCategory = foodCategoryRepository.findById(category)
                        .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                foodCategoryList.add(foodCategory);
            } catch (Exception e) {
                log.error("카테고리 조회 실패. ID: {}", category);
                throw e;
            }
        }
         */

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategories);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
