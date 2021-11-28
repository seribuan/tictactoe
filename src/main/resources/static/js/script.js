$(function(){
    $('table td').click(function(){
        $this = $(this)
        console.log(winner)
        if ($this.html() !== '' || winner == true){
            return;
        }
        let row = $this.data('row');
        let col = $this.data('col');

        $form = $('<form />').attr('method', 'POST').attr('action', `/board/${row}/${col}/write`);
        $form.appendTo(this).submit();
    })
});