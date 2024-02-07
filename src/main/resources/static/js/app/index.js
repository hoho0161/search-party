var main = {
    init : function( ) {
        var _this = this;
        $('#btn-save').on('click',function() {
            _this.save();
        });
    },

    save : function () {
        var data = {
            title: $('#title').val(),
            contents: $('#content').val(),
            ctype: $("input[name='gameType']:checked").val(),
            cmike: $("input[name='mikeCheck']:checked").val(),
            ctier: $("#selectTier").val()
        };

        if (!data.ctier) {
            alert('티어를 선택해주세요');
        }
        else if(data.title.trim().length === 0) {
            alert('제목에 텍스트를 입력해주세요');
        }
        else if(data.contents.length === 0) {
            alert('본문을 입력해주세요');
        }
        else{
            $.ajax({
                type: 'POST',
                url: '/posts',
                dataType: 'json',
                data: JSON.stringify(data),
                contentType: 'application/json; charset=utf-8'
            }).done(function(data) {
                alert('글이 등록되었습니다.');
                window.location.href = '/';

            }).fail(function (error) {
                alert(Json.stringify(error));
            });
        }
    }
};

main.init();