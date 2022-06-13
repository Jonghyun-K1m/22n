#220608
#Done	컨트롤러 -> 서비스호출 -> DB드감	
#		DB insert, search(like)구현 
#TO-DO	매핑관련 개념정리
		왜 dto써야함??? -> 일단현상황유지하고 필요에따라 진행예정
		DB update, delete 구현예정
		
		
#지금 board.java에서 JPA @entity 하고 @builder하고 양립할수없는 오류남
# @NoArgsConstructor
# -> builder는 모든인자를 가지는 인스턴스 생성함
# -> JPA는 디폴트생성자가 필요함
#해결-> @NoArgsConstructor(access = AccessLevel.PROTECTED) 히트임	
#어떡게 post된 데이터를 그냥 컨트롤러에서 board 로 받을수있는거지 어떡게;;		


#spring boot JPA 쿼리작성 ㄹㅇ놀라운게많지만 쿼리직작으로 @query 상황대비연습
#일반쿼리문과 다른구조라 JPAboardDB.java 직구현한 내용복습하기

# DTO why ???
# Entity의 값이 변하면 Repository 클래스의 Entity Manager의 flush가 호출될 때 DB에 값이 반영되고, 
# 이는 다른 로직들에도 영향을 미친다. 
# 때문에 View와 통신하면서 필연적으로 데이터의 변경이 많은 DTO 클래스를 분리해주어야 한다.
# from : https://velog.io/@ohzzi

#220610
#Done	: css적용 (indexgo)
#TO-DO	: dto, 객체정리
		: 객체(id, 작성자, 패스워드, 제목, 작성시간, (내용)
		: onclick 시 내용포함한 페이지로 진행
		: 수정,삭제버튼 클릭시 패스워드로 인증
		: 로깅처리
		:
# time관리하려면 자바8에서 hibernate 버전 맞추어서 라이브러리넣고 설정맞추어야하는 부분있는데
# hibernate5.2 윗버전에서는 하이버가 알아서해줌



#220613
#Done	: update , delete , onclick
#TO-DO	: 로깅
		: 보안(삭제등등에)
		: 객체업데이트
		: DTO
		: css 모든페이지


