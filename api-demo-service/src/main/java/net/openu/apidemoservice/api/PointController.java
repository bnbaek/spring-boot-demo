package net.openu.apidemoservice.api;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.openu.MemberDto;
import net.openu.MemberDto.Data;
import net.openu.apidemoservice.dto.PointDto;
import net.openu.apidemoservice.service.PointService;
import net.openu.mainDb.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping(value = {"/api/point", "/api/v1/point"})
public class PointController {

    private final PointService pointService;
    private final MemberService memberService;

    @PostMapping
    public String addPoint(@RequestBody PointDto.AddReq addReq) {

        pointService.addPoint();
        log.info("req {}", addReq);

        return "Point";
    }

    @PostMapping("/member")
    public ResponseEntity<Data> addMember(@RequestBody MemberDto.Req addReq) {
        Data data = memberService.addMember(addReq.getId(), addReq.getName());

        return new ResponseEntity(data, HttpStatus.OK);

    }

    @GetMapping("/member/{id}")
    public ResponseEntity<Data> getMember(@PathVariable String id) {
        Data data = memberService.getMember(id);

        return new ResponseEntity(data, HttpStatus.OK);

    }

}
