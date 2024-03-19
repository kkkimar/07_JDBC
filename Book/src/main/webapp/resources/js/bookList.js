/* 목록으로 gotoMain */
const gotoList = document.querySelector("#gotoList");
const home = document.querySelector("#home");

//sellectAll.jsp 메인으로 가는 버튼 
if(home != null){
  home.addEventListener("click",()=>{
    location.href = "/"; //메인페이지 요청
  });
}

//detail.jsp 목록으로 가는 버튼
if(gotoList != null){
  gotoList.addEventListener("click",()=>{
    location.href ="/book/sellectAll";
    // console.log("클릭");
  });
}


// 예약 가능 여부 btn
const reservationBtn = document.querySelector("#reservation-btn");

reservationBtn.addEventListener("click",(e)=>{

  const bookNo = e.target.dataset.bookNo;
  //console.log(bookNo);

  let reservation = e.target.innerText;
  //console.log(reservation);

  // Y <-> N 변경
  reservation = (reservation ==='Y') ? 'N':'Y'; // 삼항 연산자
  
  location.href = `/bookList/changeReservation?bookNo=${bookNo}&reservation=${reservation}`;

});