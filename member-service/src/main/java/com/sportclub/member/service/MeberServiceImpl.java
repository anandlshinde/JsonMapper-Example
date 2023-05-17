package com.sportclub.member.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportclub.member.entity.ClubMember;
import com.sportclub.member.entity.Product;
import com.sportclub.member.entity.ProductDto;
import com.sportclub.member.entity.TempData;
import com.sportclub.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MeberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Optional<ClubMember> registerMember(ClubMember clubMember) {
        return Optional.of(memberRepository.save(clubMember));
    }

    @Override
    public Optional<List<ClubMember>> getMembers() {
        ProductDto product=new ProductDto();
        product.setId(1L);
        product.setName("Sports");
        product.setPrice(1000.00);
        product.setDescription("test");
        product.setStock(2);
        List<Integer> numList=new ArrayList<Integer>();
        numList.add(1);
        numList.add(2);
        product.setTemlList(numList);
        /*List<TempData> numList1=new ArrayList<TempData>();
        numList1.add(new TempData(1));
        numList1.add(new TempData(2));
        product.setTemlList1(numList1);*/

        ObjectMapper mapper=new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
       Product productObj =mapper.convertValue(product,Product.class);
       // productRequestMapper(productObj);

        try {
            List<TempData> tempData = new ArrayList<>();
            for (int i : product.getTemlList()){
                tempData.add(new TempData(i));
            }
            product.setTemlList1(tempData);
            String productStr=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);
            Product product1=mapper.readValue(productStr,Product.class);
            productRequestMapper(product1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return Optional.of(memberRepository.findAll());
    }

    @Override
    public Optional<ClubMember> getMemberById(String memberId) {
        return memberRepository.findById(Long.valueOf(memberId));
    }

    @Override
    public Optional<ClubMember> updateMmeberById(String memberId,ClubMember clubMember) {
        Optional<ClubMember> clubMemberData = memberRepository.findById(Long.valueOf(memberId));
        if(clubMemberData.isPresent())
            return Optional.of(memberRepository.save(clubMember));
        else
            return Optional.of(clubMember);
    }

    @Override
    public String deleteMemberById(String memberId) {
        Optional<ClubMember> clubMemberData = memberRepository.findById(Long.valueOf(memberId));
        if(clubMemberData.isPresent()) {
            memberRepository.deleteById(Long.valueOf(memberId));
            return "Club membership deactivated";
        }else{
            return "Club membership not available with memberId: "+memberId;
        }

    }

    private void productRequestMapper(Product product){
       /* Map<String, Object> reqMap = new HashMap<String,Object>();
        reqMap.put("productId", product.getId());
        reqMap.put("productName", product.getName());
        reqMap.put("productPrice", product.getPrice());
        reqMap.put("productDescription", product.getDescription());
        reqMap.put("productStock", product.getStock());

        Object[] temp = new Object[product.getTemlList().size()];
        int j=0;
        for (int i : product.getTemlList()){
            Map<String,Object> objectMap=new HashMap<>();
            objectMap.put("temp1", i);
            temp[j] =objectMap;
            j++;

            tempData.add(new TempData(i));
        }
        reqMap.put("productTemlList", temp);
        reqMap.put("productTemlList", tempData);*/

       /* List<TempData> tempData = new ArrayList<>();
        for (int i : product.getTemlList()){
            tempData.add(new TempData(i));
        }
        product.setTemlList1(tempData);*/
        jsonRequestMapper(product);
    }
    private void jsonRequestMapper(Object json){
        try {
            //String jsonString= new ObjectMapper().writeValueAsString(json);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
            System.out.println(jsonString);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
