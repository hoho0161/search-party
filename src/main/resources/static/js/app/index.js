var main = {
    init : function( ) {
        var _this = this;
        $('#selectTier').on('change', function() {
            _this.changeTier();
        });

    },

    changeTier : function () {
        alert('JS테스트');
    }

};

main.init();