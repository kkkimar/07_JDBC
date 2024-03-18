/* 목록으로 gotoMain */
const gotomain = document.querySelector("#gotoMain");


gotomain.addEventListener("click",()=>{
  location.href = "/book/sellectAll";
});

// 예약 가능 여부 btn
const reservationBtn = document.querySelector("#reservation-btn");

reservationBtn.addEventListener("click",(e)=>{

  const bookNo = e.target.dataset.bookNo;
  //console.log(bookNo);

  let reservation = e.target.innerText;
  //console.log(reservation);

  if(reservation === 'Y'){
    reservation = 'N';
    alert("예약 성공");
  }

  location.href = `/bookList/changeReservation?bookNo=${bookNo}&reservation=${reservation}`;

});