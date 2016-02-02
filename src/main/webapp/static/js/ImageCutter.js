(function (window, undefined) {
            //定义构造函数
			//param.{blheight,blwidth,origin}
            function ImgCuter(param) {
				var self=this;
                this.image = new Image();
				
				if($("#popups").length==0){
				this._init(this);
				}else{
					$("#popups").bPopup({
						modalClose: false,
						opacity: 0.6,
						positionStyle: 'fixed' //'fixed' or 'absolute'
					});
				}
				this.param=param;
				if(this.param.circle){
					param.height=param.width;
				}
				this.blwidth=param.width;
				this.blheight=param.height;
				
				this.canvas = document.getElementById("__imgcuter-canvas");
                this.context = this.canvas.getContext("2d");
				this.view_canvas = document.getElementById("__imgcuter_view_canvas");
                this.view_context = this.view_canvas.getContext('2d');
				this.view_canvas.width=this.param.width;
				this.view_canvas.height=this.param.height;
				if(param.origin){
					this.image.src = param.origin;
					self.image.onload=function(){
						blWH=self.scaleDown(450,300,self.image.width,self.image.height);
						self.canvas.width = blWH.imgWidth;
						self.canvas.height = blWH.imgHeight;
						self.canvas.style.Width = blWH.imgWidth;
						self.canvas.style.Height = blWH.imgHeight;
						self.selectBoxScaledown();
						self.context.drawImage(self.image, 0, 0, self.image.width, self.image.height, 0, 0, self.canvas.width, self.canvas.height);
						//self.image.src = self.canvas.toDataURL();
						self.drawScene();

						self.addListerner();
					}
				}else
				{
					this.selectBoxScaledown();
                    ImgCuter.bt_file_selector.click();
				}

            }
			//选区位置大小
			ImgCuter.prototype.selectBoxScaledown=function(){
				//选区位置大小
                this.x = this.canvas.width/3;
                this.y = this.canvas.height/3;
                this.w = this.canvas.width/3;
                this.h = this.blheight/this.blwidth*this.w;
                // 拖动后的起始位置
                this.px = this.px||this.canvas.width/3;
                this.py = this.py||this.canvas.height/3;
				
				// 方块初始状态
                this.csize = 5;
                // 方块变大状态
                this.csizeh = 8;
                // 鼠标悬停在方块的状态
                this.bHow = [false, false, false, false];
                // 调整四个角方块大小
                this.iCSize = [this.csize, this.csize, this.csize, this.csize];
                // 可拖动的四个方块
                this.bDrag = [false, false, false, false];
                // 拖动整个选择区域
                this.bDragAll = false;
				//选区比例
				this.bl=this.blheight/this.blwidth;
			}
			//预览比例
			ImgCuter.prototype.showView=function(){
				return view_scaleDown=this.scaleDown(this.view_canvas.width,this.view_canvas.height,this.w,this.h);
			}
			ImgCuter.prototype._init = function(self){
				
				this.popup=document.createElement("div");
				$(this.popup).css({"left": "625px","position": "fixed","top": "25px","z-index": "9999","opacity": "1","display": "block","background-color": "#fff","border-radius": "10px 10px 10px 10px","box-shadow": "0 0 25px 5px #999","color": "#111","min-width": "450px","padding": "25px"});
				this.popup.id="popups";
				//this.popup.appendChild(document.getElement.body);
				document.body.appendChild(this.popup);
				this.container = document.createElement("div");
				this.container.id = "__imgcuter-container";
				this.container.style.width="620px";
				this.popup.appendChild(this.container);

				var canvas_c = $(document.createElement("div"));
				canvas_c.attr("id", "__imgcuter_canvas_c");
				canvas_c.css({width:"450px", height:"300px", 'text-align':"center","float":"left"});
				this.container.appendChild(canvas_c[0]);

				this.canvas = document.createElement("canvas");
				this.canvas.id = "__imgcuter-canvas";
				//$(this.canvas).css({width:'100%', height:'100%'});
				canvas_c[0].appendChild(this.canvas);
				
				var view_c=$(document.createElement("div"));
				view_c.attr("id", "__imgcuter_view_canvas_c");
				view_c.css({width:"150px", height:"280px", 'text-align':"center","float":"left","border-left":"1px solid gray","margin-left":"9px","padding-left":"9px",position:"relative"});
				this.container.appendChild(view_c[0]);
				this.view_canvas = document.createElement("canvas");
				this.view_canvas.style.position="relative";
				this.view_canvas.id = "__imgcuter_view_canvas";
				$(this.view_canvas).css({width:'150px'});
				view_c[0].appendChild(this.view_canvas);
				var imgTypeSpan=$(document.createElement("span"));
				imgTypeSpan.html("图片格式必须为以下格式：bmp, jpeg, jpg, png, gif");
				imgTypeSpan.css({'text-align':"left",'font-size':'10px','color':'gray','position':'absolute','left':'9px','bottom':'10px'});
				view_c.append(imgTypeSpan);
				
				var btnBar = document.createElement("div");
				$(btnBar).css({"width":"100%","textAlign":"right", "borderTop":"1px solid gray", "paddingTop":5,"float":"left"});
				this.container.appendChild(btnBar);

				var bt_select = $(document.createElement("input"));
				bt_select.val("选择图片");
				bt_select.attr("type", "button");
				btnBar.appendChild(bt_select[0]);
				bt_select.click(function(){
					file.click();
				});

				var file = $(document.createElement("input"));
				file.attr("id", "__imgcuter_img").attr("type", "file").attr("accept", 'accept="image/*"');
				file.css("display", "none");
				btnBar.appendChild(file[0]);
				file.change(function(e){
					 self.imgSelected(self);
				});
                ImgCuter.bt_file_selector = file;
				
				var bt_done = $(document.createElement("input"));
				bt_done.attr("type", "button");
				bt_done.addClass("button b-close");
				bt_done.val(" 确 定 ")
				btnBar.appendChild(bt_done[0]);
				bt_done.click(function(){
					self.getresult();
					self.disposeEvent();
					if(self.param.onClose){
						cuterBox.close();
						self.param.onClose.call(self, self.image.src);
					}
					$("#popups").remove();
				});
				
				
				var cancelBtn=$(document.createElement("input"));
				cancelBtn.val("取消");
				cancelBtn.addClass("button b-close");
				cancelBtn.attr("type", "button");
				btnBar.appendChild(cancelBtn[0]);
				
				var cuterBox = $(this.popup).bPopup({
					modalClose: false,
					opacity: 0.6,
					positionStyle: 'fixed', //'fixed' or 'absolute'
					onOpen: function() {
						//cuter.show(content[0]);
	//                    var ddd = this;
	//                    $("#__imgcuter_done").click(function(){ddd.close();});
					},
					onClose: function() {
						//content.empty();
					}
				});
			};
			ImgCuter.prototype.imgSelected=function(self){
				
				oFReader = new FileReader(), rFilter = /^(?:image\/bmp|image\/cis\-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x\-cmu\-raster|image\/x\-cmx|image\/x\-icon|image\/x\-portable\-anymap|image\/x\-portable\-bitmap|image\/x\-portable\-graymap|image\/x\-portable\-pixmap|image\/x\-rgb|image\/x\-xbitmap|image\/x\-xpixmap|image\/x\-xwindowdump)$/i;
				oFReader.onload = function (oFREvent) {
					self.image.src = oFREvent.target.result;
						
					self.image.onload = function () {
					
						self.blWH=self.scaleDown(450,300,self.image.width,self.image.height);
						self.canvas.width = self.blWH.imgWidth;
						self.canvas.height = self.blWH.imgHeight;
						self.canvas.style.Width = self.blWH.imgWidth;
						self.canvas.style.Height = self.blWH.imgHeight;
						self.selectBoxScaledown();
						self.context.drawImage(self.image, 0, 0, self.image.width, self.image.height, 0, 0, self.canvas.width, self.canvas.height);
						//self.image.src = self.canvas.toDataURL();
						self.drawScene();
						self.addListerner();
					}
                }
				if (document.getElementById("__imgcuter_img").files.length === 0) { return; }
                var oFile = document.getElementById("__imgcuter_img").files[0];
                if (!rFilter.test(oFile.type)) { alert("You must select a valid image file!"); return; }
                oFReader.readAsDataURL(oFile);
				
				
				$("#__imgcuter_img").val("");
				
			}
			
			
			
			
			
            //画出背景
            ImgCuter.prototype.drawScene = function () { // main drawScene function
                this.context.drawImage(this.image, 0, 0, this.canvas.width, this.canvas.height);
                this.context.fillStyle = 'rgba(0, 0, 0, 0.5)';
                this.context.fillRect(0, 0, this.canvas.width, this.canvas.height);
                // 画出选区
                this.draw();
            }
            //画出选区
            ImgCuter.prototype.draw = function () {
                this.context.strokeStyle = '#fff';
                this.context.lineWidth = 0.5;
                this.context.strokeRect(this.x, this.y, this.w, this.h);
					
                // 绘制选区图像
                if (this.w > 0 && this.h > 0) {
                    this.context.drawImage(this.image, this.x*this.image.width/this.canvas.width, this.y*this.image.width/this.canvas.width, this.w*this.image.width/this.canvas.width, this.h*this.image.width/this.canvas.width,this.x, this.y, this.w, this.h);
					//this.context.drawImage(this.image, this.x/this.image.width*this.w, this.y/this.image.height*this.h, 10, 10, this.x, this.y, this.w, this.h);
					this.view_context.clearRect(0,0,this.view_canvas.width,this.view_canvas.height);
					this.view_context.drawImage(this.image, this.x*this.image.width/this.canvas.width, this.y*this.image.width/this.canvas.width, this.w*this.image.width/this.canvas.width, this.h*this.image.width/this.canvas.width, 0, 0, this.showView().imgWidth, this.showView().imgHeight);
					if(this.param.circle){
						var circleX=this.showView().imgWidth/2;
						var circleY=this.showView().imgHeight/2;
						var circleBorder=this.showView().imgWidth;
						this.view_context.lineWidth=circleBorder;
						this.view_context.beginPath();
						this.view_context.strokeStyle="rgba(255,255,255,1)";
						this.view_context.arc(circleX,circleY,circleX+circleBorder/2,0,Math.PI*2,true);
						this.view_context.stroke();
						this.view_context.closePath();
					}
				}
                // 画出四个角的调整方块
                this.context.fillStyle = 'rgba(255, 255, 255, 1)';
                this.context.fillRect(this.x - this.iCSize[0], this.y - this.iCSize[0], this.iCSize[0] * 2, this.iCSize[0] * 2);
                this.context.fillRect(this.x + this.w - this.iCSize[1], this.y - this.iCSize[1], this.iCSize[1] * 2, this.iCSize[1] * 2);
                this.context.fillRect(this.x + this.w - this.iCSize[2], this.y + this.h - this.iCSize[2], this.iCSize[2] * 2, this.iCSize[2] * 2);
                this.context.fillRect(this.x - this.iCSize[3], this.y + this.h - this.iCSize[3], this.iCSize[3] * 2, this.iCSize[3] * 2);
                this.drawLine();
            }
            //画出九宫格
            ImgCuter.prototype.drawLine = function () {
                this.context.strokeStyle = "#fff";
                this.context.strokeRect(this.x, this.y + parseFloat(this.h / 3), this.w, 0.05);
                this.context.strokeRect(this.x, this.y + parseFloat(this.h / 3) * 2, this.w, 0.05);
                this.context.strokeRect(this.x + parseFloat(this.w / 3), this.y, 0.05, this.h);
                this.context.strokeRect(this.x + parseFloat(this.w / 3) * 2, this.y, 0.05, this.h);
				
				if(this.param.circle)
					this.drawCircle();
					
            }
			ImgCuter.prototype.drawCircle = function (borderW) {
                    this.context.beginPath();
                    this.context.lineWidth = 500;
                    this.context.arc(this.x+this.w/2, this.y+this.h/2, this.w/2+250, 0, Math.PI * 2, true);
                    this.context.strokeStyle = "rgba(255,255,255,0.5)";
                    this.context.stroke();
					this.context.closePath();
					this.context.lineWidth = 0.5;
            }
			//////////////////////////按比例缩放选区
			ImgCuter.prototype.selectContral=function(width){
				return this.bl*width;
			}
			//计算相对于页面位置
			ImgCuter.prototype.GetAbsoluteLocationEx=function(element){
				if(arguments.length!=1||element==null)
				{
				return null;
				}
				var elmt=element;
				var offsetTop=elmt.offsetTop;
				var offsetLeft=elmt.offsetLeft;
				var offsetWidth=elmt.offsetWidth;
				var offsetHeight=elmt.offsetHeight;
				while(elmt=elmt.offsetParent)
				{
				// add this judge
				if(elmt.style.position=='absolute'||elmt.style.position=='relative'
				||(elmt.style.overflow!='visible'&&elmt.style.overflow!=''))
				{
				break;
				}
				offsetTop+=elmt.offsetTop;
				offsetLeft+=elmt.offsetLeft;
				}
				return{absoluteTop:offsetTop,absoluteLeft:offsetLeft,
				offsetWidth:offsetWidth,offsetHeight:offsetHeight};
			}
            //鼠标移动事件
            ImgCuter.prototype.mousemove = function (e) {
				//var addd=this.GetAbsoluteLocationEx(this.canvas).absoluteTop;
                var iMouseX = Math.floor(e.pageX -$("body").scrollLeft()- this.GetAbsoluteLocationEx(this.canvas).absoluteLeft);
                var iMouseY = Math.floor(e.pageY -$("body").scrollTop()- this.GetAbsoluteLocationEx(this.canvas).absoluteTop);

                if(iMouseX<=2 || iMouseX>=this.canvas.width-2 || iMouseY<=2 || iMouseY>=this.canvas.height-2){
                    this.mouseup();
                }
                // 拖整体的选择器
                if (iMouseX - this.px >= 0 || iMouseY - this.y >= 0) {
                    this.canvas.style.cursor = "move";
                    if (this.bDragAll) {
                        this.context.clearRect(this.x, this.y, this.w, this.h);

                        this.x = iMouseX - this.px;
                        this.y = iMouseY - this.py;

                        if (this.x < 0) {
                            this.x = 0;
                        }
                        if (this.y < 0) {
                            this.y = 0;
                        }
                        if ((this.w + this.x) > this.canvas.width) {
                            this.x = this.x - (this.w + this.x - this.canvas.width);
                        }
                        if ((this.h + this.y) > this.canvas.height) {
                            this.y = this.y - (this.h + this.y - this.canvas.height);
                        }
                    }
                }
                for (i = 0; i < 4; i++) {
                    this.bHow[i] = false;
                    this.iCSize[i] = this.csize;
                }
                // 悬停在调整方块
                if (iMouseX > this.x - this.csizeh && iMouseX < this.x + this.csizeh &&
            iMouseY > this.y - this.csizeh && iMouseY < this.y + this.csizeh) {
                    this.bHow[0] = true;
                    this.iCSize[0] = this.csizeh;
                    this.canvas.style.cursor = "nw-resize";
                }
                //this.canvas.style.cursor = "default";
                if (iMouseX > this.x + this.w - this.csizeh && iMouseX < this.x + this.w + this.csizeh &&
            iMouseY > this.y - this.csizeh && iMouseY < this.y + this.csizeh) {
                    this.bHow[1] = true;
                    this.iCSize[1] = this.csizeh;
                    this.canvas.style.cursor = "ne-resize";
                }
                if (iMouseX > this.x + this.w - this.csizeh && iMouseX < this.x + this.w + this.csizeh &&
            iMouseY > this.y + this.h - this.csizeh && iMouseY < this.y + this.h + this.csizeh) {
                    this.bHow[2] = true;
                    this.iCSize[2] = this.csizeh;
                    this.canvas.style.cursor = "se-resize";
                }
                if (iMouseX > this.x - this.csizeh && iMouseX < this.x + this.csizeh &&
            iMouseY > this.y + this.h - this.csizeh && iMouseY < this.y + this.h + this.csizeh) {
                    this.bHow[3] = true;
                    this.iCSize[3] = this.csizeh;
                    this.canvas.style.cursor = "sw-resize";
                }

                // 如果拖动方块
                var iFW, iFH;
                var iFX, iFY;
                if (this.bDrag[0]) {
                    iFX = iMouseX - this.px;
                    iFY = iMouseY - this.py;
                    iFW = this.w + this.x - iFX;
                    //iFH = this.h + this.y - iFY;
					iFH=this.selectContral(iFW);
                }
                if (this.bDrag[1]) {
                    iFX = this.x;
                    iFY = iMouseY - this.py;
                    iFW = iMouseX - this.px - iFX;
                    //iFH = this.h + this.y - iFY;
					iFH=this.selectContral(iFW);
                }
                if (this.bDrag[2]) {
                    iFX = this.x;
                    iFY = this.y;
                    iFW = iMouseX - this.px - iFX;
                    //iFH = iMouseY - this.py - iFY;
					iFH=this.selectContral(iFW);
                }
                if (this.bDrag[3]) {
                    iFX = iMouseX - this.px;
                    iFY = this.y;
                    iFW = this.w + this.x - iFX;
                    //iFH = iMouseY - this.py - iFY;
					iFH=this.selectContral(iFW);
                }
                //判断选区不能太小，大于四个角宽度
                if (iFW > this.csizeh * 2 && iFH > this.csizeh * 2) {
                    this.w = iFW;
                    this.h = iFH;
                    this.x = iFX;
                    this.y = iFY;
                }
                this.drawScene();
            }
            //鼠标按下事件
            ImgCuter.prototype.mousedown = function (e) {
                var iMouseX = Math.floor(e.pageX -$("body").scrollLeft()- this.GetAbsoluteLocationEx(this.canvas).absoluteLeft);
                var iMouseY = Math.floor(e.pageY -$("body").scrollTop()- this.GetAbsoluteLocationEx(this.canvas).absoluteTop);
                this.px = iMouseX - this.x;
                this.py = iMouseY - this.y;
                if (this.bHow[0]) {
                    this.px = iMouseX - this.x;
                    this.py = iMouseY - this.y;
                }
                if (this.bHow[1]) {
                    this.px = iMouseX - this.x - this.w;
                    this.py = iMouseY - this.y;
                }
                if (this.bHow[2]) {
                    this.px = iMouseX - this.x - this.w;
                    this.py = iMouseY - this.y - this.h;
                }
                if (this.bHow[3]) {
                    this.px = iMouseX - this.x;
                    this.py = iMouseY - this.y - this.h;
                }
                if (iMouseX > this.x + this.csizeh && iMouseX < this.x + this.w - this.csizeh &&
            iMouseY > this.y + this.csizeh && iMouseY < this.y + this.h - this.csizeh) {

                    this.bDragAll = true;
                }
                for (i = 0; i < 4; i++) {
                    if (this.bHow[i]) {
                        this.bDrag[i] = true;
                    }
                }
            }
            //鼠标弹起事件
            ImgCuter.prototype.mouseup = function () {
                this.bDragAll = false;
                for (i = 0; i < 4; i++) {
                    this.bDrag[i] = false;
                }
                this.px = 0;
                this.py = 0;
            }
            //添加鼠标监听事件
            ImgCuter.prototype.addListerner = function () {
                var temp = this;
                this.canvas.onmousemove = function (e) {
                    temp.mousemove(e);
                }
                this.canvas.onmousedown = function (e) {
                    temp.mousedown(e);
                }
                this.canvas.onmouseup = function () {
                    temp.mouseup();
                }
            }
            //注销鼠标事件
            ImgCuter.prototype.disposeEvent = function () {
                this.canvas.onmousemove = null;
                this.canvas.onmousedown = null;
                this.canvas.onmouseup = null;
				this.canvas.style.cursor = "default";
            }
			/*
			比例缩小
			maxWidth:允许的最大宽度
			maxHeight:允许的最大高度
			imgWidth:原图片的宽度
			imgWidth：原图片的高度
			return：返回按原图比例缩小后的宽高
			*/
			ImgCuter.prototype.scaleDown=function (maxWidth, maxHeight, imgWidth, imgHeight) {
                //缩小比例
				var wbl = Math.floor(maxWidth / imgWidth * 100) / 100;
				var hbl = Math.floor(maxHeight / imgHeight * 100) / 100;
				
				
				//如果图片超过操作区域就按宽或高比例缩小
				if (imgWidth > maxWidth && imgHeight > maxHeight || imgWidth < maxWidth && imgHeight < maxHeight) {
					if (imgWidth > imgHeight) {
						imgWidth = maxWidth;
						imgHeight *= wbl;
					} else if (imgWidth < imgHeight) {
						imgHeight = maxHeight;
						imgWidth *= hbl;
					}
				} else if (imgWidth > maxWidth) {
					imgWidth = maxWidth;
					imgHeight *= wbl;
				} else if (imgHeight > maxHeight) {
					imgHeight = maxHeight;
					imgWidth *= hbl;
				}
				//再次缩小比例
				var wbl = Math.floor(maxWidth / imgWidth * 100) / 100;
				var hbl = Math.floor(maxHeight / imgHeight * 100) / 100;

				//如果图片超过操作区域就按宽或高比例缩小
				if (imgWidth > maxWidth && imgHeight > maxHeight) {
					if (imgWidth > imgHeight) {
						imgWidth = maxWidth;
						imgHeight *= wbl;
					} else if (imgWidth < imgHeight) {
						imgHeight = maxHeight;
						imgWidth *= hbl;
					}
				} else if (imgWidth > maxWidth) {
					imgWidth = maxWidth;
					imgHeight *= wbl;
				} else if (imgHeight > maxHeight) {
					imgHeight = maxHeight;
					imgWidth *= hbl;
				}
				//console.log(imgWidth/maxWidth+" "+imgHeight/maxHeight);
				return { "imgWidth": imgWidth, "imgHeight": imgHeight };
            }
            /*var scaleImage=function(base64,maxWidth, maxHeight){
                var newImage=new Image();
                newImage.src=base64;
                var imgWidth=newImage.width,imgHeight=newImage.height;
                //缩小比例
                var wbl = Math.floor(maxWidth / imgWidth * 100) / 100;
                var hbl = Math.floor(maxHeight / imgHeight * 100) / 100;
                //如果图片超过操作区域就按宽或高比例缩小
                if (imgWidth > maxWidth && imgHeight > maxHeight || imgWidth < maxWidth && imgHeight < maxHeight) {
                    if (imgWidth > imgHeight) {
                        imgWidth = maxWidth;
                        imgHeight *= wbl;
                    } else if (imgWidth < imgHeight) {
                        imgHeight = maxHeight;
                        imgWidth *= hbl;
                    }
                } else if (imgWidth > maxWidth) {
                    imgWidth = maxWidth;
                    imgHeight *= wbl;
                } else if (imgHeight > maxHeight) {
                    imgHeight = maxHeight;
                    imgWidth *= hbl;
                }
                //再次缩小比例
                var wbl = Math.floor(maxWidth / imgWidth * 100) / 100;
                var hbl = Math.floor(maxHeight / imgHeight * 100) / 100;
                //如果图片超过操作区域就按宽或高比例缩小
                if (imgWidth > maxWidth && imgHeight > maxHeight) {
                    if (imgWidth > imgHeight) {
                        imgWidth = maxWidth;
                        imgHeight *= wbl;
                    } else if (imgWidth < imgHeight) {
                        imgHeight = maxHeight;
                        imgWidth *= hbl;
                    }
                } else if (imgWidth > maxWidth) {
                    imgWidth = maxWidth;
                    imgHeight *= wbl;
                } else if (imgHeight > maxHeight) {
                    imgHeight = maxHeight;
                    imgWidth *= hbl;
                }
                newImage.width=imgWidth;
                newImage.height=imgHeight;

                var temp_ctx, temp_canvas;
                temp_canvas = document.createElement('canvas');
                temp_ctx = temp_canvas.getContext('2d');
                temp_canvas.width = newImage.width;
                temp_canvas.height = newImage.height;
                temp_ctx.drawImage(newImage,0,0);
                return temp_canvas.toDataURL();
            };*/
            //得到裁剪选区
            ImgCuter.prototype.getresult = function () {
				
				if(this.param.circle){
					this.image.src=this.tempCircleCanvas();
				}
                this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
                this.canvas.style.Width = this.w;
                this.canvas.style.Height = this.h;
                var canvasW=this.canvas.width;
				var canvasH=this.canvas.height;
				this.canvas.width = this.w;
                this.canvas.height = this.h;
				this.context.drawImage(this.image, this.x*this.image.width/canvasW, this.y*this.image.width/canvasW, this.w*this.image.width/canvasW, this.h*this.image.width/canvasW,0, 0, this.w, this.h);
				
				
				var temp_ctx, temp_canvas;
				temp_canvas = document.createElement('canvas');
				temp_ctx = temp_canvas.getContext('2d');
				temp_canvas.width = (this.w*this.image.width/canvasW)>this.blwidth?this.blwidth:(this.w*this.image.width/canvasW);
				temp_canvas.height = (this.h*this.image.height/canvasH)>this.blheight?this.blheight:(this.h*this.image.height/canvasH);
				temp_ctx.drawImage(this.image, this.x*this.image.width/canvasW, this.y*this.image.height/canvasH, this.w*this.image.width/canvasW, this.h*this.image.height/canvasH, 0, 0, temp_canvas.width, temp_canvas.height);
				
				
				var vData = temp_canvas.toDataURL();
				this.image.src = vData;
				return vData;
				
				
            }
			ImgCuter.prototype.tempCircleCanvas=function(){
				var temp_ctx, temp_canvas;
				var canvasW=this.canvas.width;
				var canvasH=this.canvas.height;
				var circleX=(this.x+this.w/2)*this.image.width/canvasW;
				var circleY=(this.y+this.h/2)*this.image.height/canvasH;
				var circleBorder=this.image.width>this.image.height?this.image.width:this.image.height;
				temp_canvas = document.createElement('canvas');
				temp_ctx = temp_canvas.getContext('2d');
				temp_canvas.width = this.image.width;
				temp_canvas.height = this.image.height;
				temp_ctx.drawImage(this.image, 0,0);
				temp_ctx.lineWidth=circleBorder;
				temp_ctx.globalCompositeOperation="source-out";
				temp_ctx.beginPath();
				temp_ctx.strokeStyle="rgba(255,255,255,1)";
				temp_ctx.arc(circleX,circleY,(this.w*this.image.width/canvasW)/2+circleBorder/2,0,Math.PI*2,true);
				temp_ctx.stroke();
				
				temp_ctx.closePath();
				var vData = temp_canvas.toDataURL();
				//window.open(vData);
				return vData;
				
			}
            window["ImgCuter"] = ImgCuter;
        })(window);
			