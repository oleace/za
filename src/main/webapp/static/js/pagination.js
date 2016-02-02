var Pagination = function(form){
    this.initialize(form);
};

Pagination.prototype = {
	initialize:function(form){
		this.formName = form;
		this.curPage = form + "PAGINATION_CURRENTPAGE";
		this.pageSize = form + "PAGINATION_PAGESIZE";

		this.form = document.getElementById(this.formName)||document.getElementsByName(form)[0];

		if (!this.form)
			this.form = document.forms.item(0);
		
	},
    submit : function(){
        for(i=0;i<this.form.length;i++){
            if(this.form.elements[i].type=="submit"){
                this.form.elements[i].click();
                return;
            }
        }

        var smt = document.createElement("input");
        smt.type="submit";
        smt.value=null;
        smt.style["display"]="none";
        this.form.appendChild(smt);
        smt.click();
    },
	changePage:function(p){
		if(this.form.elements["PAGINATION_CURRENTPAGE"]==null){
			var cp = document.createElement("input");
			cp.type="hidden";
			cp.name="PAGINATION_CURRENTPAGE";
			cp.id="PAGINATION_CURRENTPAGE";
			this.form.appendChild(cp);
		}
		this.form.elements["PAGINATION_CURRENTPAGE"].value=p;
		
		if(this.form.elements["PAGINATION_PAGESIZE"]==null){
			var ps =document.createElement("input");
			ps.type="hidden";
			ps.name="PAGINATION_PAGESIZE";
			ps.id="PAGINATION_PAGESIZE";
			this.form.appendChild(ps);
		}
		this.form.elements["PAGINATION_PAGESIZE"].value=document.getElementById(this.pageSize).value;
		//simulate submit button of form on click event.
		//solved the script submit() bug.
		//sunyitao 06/6/27 23:31
		this.submit();
	},
	defaultPage:function(){
	   document.getElementById(this.curPage).selectedIndex=0;
	}
}