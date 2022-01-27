var comment0 = 1;
var feed_like = 1;

$.ajax({
    url : "http://localhost:8080/api/feed",
    type : "get",
    dataType : "json",
    success : function(data){
        $.each(data, function(item, item){

            for(i = 0; i < item.length; i++){
                console.log(item[i].addr);

                $(".test"+i).attr("src", item[i].addr);
                $(".owner"+i).text(item[i].id);
                $(".content"+i).text(item[i].content);
            }
        });
    },
    error : function(){
        alert('error');
    }
                
}); 


function like(){
    if(feed_like == 1){
        document.getElementById("feed_like").src = "img/like.svg";
        feed_like-=1;
    }
    else{
        document.getElementById("feed_like").src = "img/heart.svg";
        feed_like+=1;
    }
}

function comment_like(i){
    var className= document.getElementById("comment"+i).className;
    if(className == "heart"){
        document.getElementById("comment"+i).className = "red_heart";
    }
    else{
        document.getElementById("comment"+i).className = "heart";
    }
} 

// function comment1_like(){
//     if(comment1 == 1){
//         document.getElementById("comment1").src = "img/like.svg";
//         comment1-=1;
//     }
//     else{
//         document.getElementById("comment1").src = "img/heart.svg";
//         comment1+=1;
//     }
//}

// function comment2_like(){
//     if(comment2 == 1){
//         document.getElementById("comment2").src = "img/like.svg";
//         comment2-=1;
//     }
//     else{
//         document.getElementById("comment2").src = "img/heart.svg";
//         comment2+=1;
//     }
// }

// function comment5_like(){
//     if(comment5 == 1){
//         document.getElementById("comment5").src = "img/like.svg";
//         comment5-=1;
//     }
//     else{
//         document.getElementById("comment5").src = "img/heart.svg";
//         comment5+=1;
//     }
// }

$(document).ready(function func(){
    $("input[class=comment_body]").on("propertychange change keyup paste input", function() {
        if($(".comment_body").val()==""){
            $(".comment_btn").css("color", "rgba(0, 140, 255, 0.3)");
            $(".comment_btn").css("cursor", "Default");
        }
        else{
            $(".comment_btn").css("color", "rgba(0, 140, 255, 1)");
            $(".comment_btn").css("cursor", "pointer");
        }
    });
});