#220608
#Done	컨트롤러 -> 서비스호출 -> DB드감		
#TO-DO	매핑관련 개념정리
		왜 dto써야함??? -> 일단현상황유지하고 필요에따라 진행예정
		
#지금 board.java에서 JPA @entity 하고 @builder하고 양립할수없는 오류남
#해결-> @NoArgsConstructor(access = AccessLevel.PROTECTED) 히트임	
#어떡게 post된 데이터를 그냥 컨트롤러에서 board 로 받을수있는거지 어떡게;;		