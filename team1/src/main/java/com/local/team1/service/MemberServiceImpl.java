package com.local.team1.service;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.local.team1.domain.LoginDto;
import com.local.team1.domain.MemberVo;
import com.local.team1.persistence.MemberDao;
import com.local.team1.util.MailHandler;
import com.local.team1.util.TempKey;
@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDao memberDao;
	
	@Inject
	private JavaMailSender mailSender;
	
	@Override
	public MemberVo login(LoginDto loginDto) throws Exception {
		return memberDao.readWithPw(loginDto.getMem_id(), loginDto.getMem_pw());
	}
	
	@Transactional
	@Override
	public void join(MemberVo vo) throws Exception {
		memberDao.insertMember(vo);
		System.out.println("----1-----");
//		String key = new TempKey().getKey(50, false);
		System.out.println("----2-----");
//		memberDao.createAuthKey(vo.getAuth_key(), key);
		System.out.println("----3-----");
		MailHandler sendMail = new MailHandler(mailSender);
		System.out.println("----4-----");
		sendMail.setSubject("[서비스 이메일 인증]");
		System.out.println("----5-----");
		sendMail.setText(
				new StringBuffer().append("<h1>메일인증</h1>").append("<a href='http://localhost/mem/emailConfirm?mem_id=").append(vo.getMem_id()).append("&mem_email=").append(vo.getMem_email()).append("' target='_blenk'>이메일 인증 확인</a>").toString());
		System.out.println("----6-----");
		sendMail.setFrom("devstep88@gmail.com", "걸음마코드");
		System.out.println("----7-----");
		sendMail.setTo(vo.getMem_email());
		System.out.println("----8-----");
		sendMail.send();
		System.out.println("----9-----");
	}

	@Override
	public int CheckId(String mem_id) throws Exception {
		return memberDao.readMember(mem_id);
	}

	@Override
	public void modifyMember(MemberVo vo) throws Exception {
		memberDao.updateMember(vo);
		
		
	}

	@Override
	public void modifyNopic(MemberVo vo) throws Exception {
		memberDao.updateNopic(vo);
		
	}

	@Override
	public MemberVo readMemInfo(String mem_id) throws Exception {
		return memberDao.readMemInfo(mem_id);
	}

	@Override
	public void pw_change(String mem_pw, String mem_id) throws Exception {
		memberDao.update_pw(mem_pw, mem_id);
		
	}

	@Override
	public int CheckPw(String mem_pw) throws Exception {
		return memberDao.readPw(mem_pw);
	}
	@Override
	public void deletePic(String mem_id) throws Exception {
		memberDao.deletePic(mem_id);

	}

	@Override
	public void verifyMember(MemberVo vo) throws Exception {
		memberDao.verifyMember(vo);
		
	}


}
