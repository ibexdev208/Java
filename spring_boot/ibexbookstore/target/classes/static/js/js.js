function showIconsPanel(ele) {
  const srcElement = document.getElementById(ele);

  if(srcElement != null){
      if(srcElement.style.display == "block"){
          srcElement.style.display = "none";
      }else{
          srcElement.style.display = "block";
      }
      return false;    
  }
}



window.onload = function yHandler() {
  var brgrBg = document.getElementById('toggleNavBar');
  var yOffset = window.pageYOffset;
  if(yOffset >= 80){
    brgrBg.classList.add("burgerBgOnScroll");
  }else{
    brgrBg.classList.remove("burgerBgOnScroll");
  }
}

function closePanel() {
  document.getElementById("icon-panel").style.width = "0";
}


function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}