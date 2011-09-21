function oL(){}
function QO(){}
function rP(){}
function vP(){}
function FR(){}
function FW(){}
function bW(){}
function tX(){}
function Zb(){Ub(Mb)}
function Ub(b){Pb(b,b.e)}
function fy(b,c){Ux(c,b)}
function HW(b){this.b=b}
function GR(b){this.a=b}
function TO(b){SO();this.a=b}
function tW(b){return b.r?b.e?2:1:b.e?1:0}
function hW(b){if(!b.e){return 0}return b.f}
function kW(b){if(!b.e){return 0}return b.i}
function iW(b){if(!b.e||b.e.j){return 0}return hW(b)}
function lW(b){if(!b.e||!b.e.j){return 0}return kW(b)}
function rW(b,c){b.o=c;b.k.style[Zqb]=c+b.d+(gg(),F7);xW(b)}
function yW(b){var c,d;d=JK(b.s);c=IK(b.s);b.t.f=d;b.t.e=c}
function wW(b){b.i=0;b.f=0;if(b.e){b.i=rL(b.e);b.f=pL(b.e);b.g=sL(b.e)}}
function AK(b){zK();b.attachEvent(B7,function(){CK(b)},false)}
function KG(b){var c;c=(zI(),!yI&&(yI=new RI),zI(),yI);c.a.g&&c.a.b==6&&AK(b)}
function oW(b,c,d,e){e<0&&(zI(),!yI&&(yI=new RI),zI(),yI).a.k&&(b.k.style[E7]=lqb,undefined);Al(b.r,24).Xc(c,d)}
function VK(b,c){zK();(zI(),!yI&&(yI=new RI),zI(),yI).a.g?(b.style[Iqb]=c,undefined):(b.style[Jqb]=c,undefined)}
function cW(b){rW(b,b.o);!!b.e&&(b.e.rb.style[u9]=b.b+(gg(),F7),undefined);b.s.style[u9]=b.c+(gg(),F7)}
function uW(b,c,d){d==-1&&(d=b.j.Yc());c==-1&&(c=b.j.Zc());b.d=eW(b,d);dW(b,c);cW(b)}
function Sw(b,c,d){d>=b.children.length?b.appendChild(c):b.insertBefore(c,b.children[d])}
function tP(b){this.rb=Jd($doc,Cfb);this.rb[Uqb]=c4;this.rb[H7]=Vqb;this.a=b;KG(this.rb)}
function sP(b,c){var d;if(!oY(c,b.b)){Lv(b.rb,32768|(b.rb.__eventBits||0));d=nH(b.a,c);b.rb[hdb]=d;b.b=c}}
function sW(b,c){if(c==b.r){return}!!c&&Sx(c);!!b.r&&nW(b,b.r);b.r=c;if(c){b.s.appendChild(b.r.rb);Ux(c,b)}}
function rL(b){var c;c=0;!!b.e&&(c+=JK(b.e.rb));!!b.a&&(c+=JK(b.a));!!b.k&&(c+=JK(b.k));!!b.d&&(c+=JK(b.d));return c}
function pL(b){var c,d;d=0;if(b.e){c=IK(b.e.rb);c>0&&(d=c)}if(b.a){c=IK(b.a);c>d&&(d=c)}if(b.k){c=IK(b.k);c>d&&(d=c)}if(b.d){c=IK(b.d);c>d&&(d=c)}return d}
function SO(){SO=T3;new TO(1);new TO(2);new TO(4);new TO(8);new TO(16);new TO(32);RO=new TO(5)}
function qW(b,c,d){var e,f;f=c;f+=b.n.Zc();e=d;e+=b.n.Yc();if(f<0){zL.Qc(Xqb+f);f=0}if(e<0){zL.Qc(Yqb+e);e=0}b.j.f=f;b.j.e=e;xW(b)}
function qL(b,c){var d;d=0;if(oY(c,kgb)){return 0}!!b.e&&++d;if(oY(c,rcb)){return d}!!b.a&&++d;if(oY(c,Qbb)){return d}!!b.k&&++d;return d}
function xL(b){if(b[1][rcb]!=null){return true}if(R6 in b[1]){return true}if(kgb in b[1]){return true}if(Qbb in b[1]){return true}return false}
function Pb(b,c){var d;d=c==b.e?i4:j4+c;!!$stats&&$stats(sc(d,ipb,c,-1));c<b.f.length&&tl(b.f,c,null);Tb(b,c)&&dc(b.g);b.a=-1;b.c[c]=true;Xb(b)}
function nW(b,c){if(c!=b.e&&c!=b.r){return false}Ux(c,null);if(c==b.e){b.k.removeChild(c.rb);b.e=null}else{b.s.removeChild(c.rb);b.r=null}return true}
function EW(b,c){if((zI(),!yI&&(yI=new RI),zI(),yI).a.g){b.style[Iqb]=c;oY(c,T7)?(b.style[P8]=y9,undefined):(b.style[P8]=Q8,undefined)}else{b.style[Jqb]=c}}
function pW(b,c){!!c&&Sx(c);!!b.e&&c!=b.e&&nW(b,b.e);b.e=c;if(b.e){if(b.e.j){VK(b.e.rb,T7);b.k.appendChild(b.e.rb)}else{VK(b.e.rb,c4);b.k.insertBefore(b.e.rb,b.s)}fy(b,b.e)}}
function RK(b){zK();var c,d,e,f,g,i;d=false;i=c4;c=c4;if(E7 in b[1]){d=true;i=b[1][E7]}if(G7 in b[1]){d=true;c=b[1][G7]}if(!d){return null}g=QK(i);e=QK(c);f=new QJ(g,e);return f}
function xW(b){var c,d;d=b.j.Zc();c=b.j.Yc()-b.d;d<0&&(d=0);c<0&&(c=0);b.rb.style[E7]=d+F7;b.rb.style[G7]=c+F7;if(b.e){b.e.j?tL(b.e,b.i):tL(b.e,d);b.i=rL(b.e);b.e.rb.style[G7]=c4}}
function GW(b,c){if(c==0){if(b.b.r){return b.b.r}else if(b.b.e){return b.b.e}else{throw new Q3}}else if(c==1){if(!!b.b.r&&!!b.b.e){return b.b.e}else{throw new Q3}}else{throw new Q3}}
function sL(b){var c,d,e;e=0;!!b.e&&(e+=JK(b.e.rb));if(b.a){d=b.a.scrollWidth||0;if((zI(),!yI&&(yI=new RI),zI(),yI).a.e){c=JK(b.a);c>d&&(d=c)}e+=d}!!b.k&&(e+=JK(b.k));!!b.d&&(e+=JK(b.d));return e}
function vL(b,c){bA.call(this);this.c=c;this.i=b;!!c&&!!this.i&&(this.rb.vOwnerPid=Al(this.i,58).rb.tkPid,undefined);this.rb[H7]=Kqb;this.ob==-1?Lv(this.rb,241|(this.rb.__eventBits||0)):(this.ob|=241)}
function eW(b,c){var d;if((b.a.a&4)==4){return 0}if(b.e){if(b.e.j){c-=aY(b.t.Yc(),pL(b.e))}else{c-=b.t.Yc();c-=hW(b)}}else{c-=b.t.Yc()}d=0;(b.a.a&32)==32?(d=~~(c/2)):(b.a.a&8)==8&&(d=c);d<0&&(d=0);return d}
function vW(b,c,d){var e,f;if(xL(c)){e=b.e;if(!e){e=new vL(Al(b.r,24),d);e.rb.style[G7]=$qb;(zI(),!yI&&(yI=new RI),zI(),yI).a.g&&pW(b,e)}f=uL(e,c);(e!=b.e||f)&&pW(b,e)}else{!!b.e&&nW(b,b.e)}wW(b);!b.q&&(b.q=RK(c),undefined)}
function HK(b,c,d){var i,k;zK();var e,f,g;g=Al(c,58).rb;while(!!d&&d!=g){f=(i=b.g[d.tkPid],!i?null:i.a);if(!f){e=d.vOwnerPid;e!=null&&(f=(k=b.g[e],!k?null:k.a))}if(f){while(!!d&&d!=g){d=Gd(d)}return d!=g?null:f}d=Gd(d)}return null}
function dW(b,c){var d,e;b.b=0;b.c=0;if((b.a.a&1)==1){return}d=c;e=c;if(b.e){if(b.e.j){d=0;e-=b.t.Zc();e-=kW(b)}else{e-=b.t.Zc();d-=kW(b)}}else{d=0;e-=b.t.Zc()}if((b.a.a&16)==16){b.b=~~(d/2);b.c=~~(e/2)}else if((b.a.a&2)==2){b.b=d;b.c=e}b.b<0&&(b.b=0);b.c<0&&(b.c=0)}
function tL(b,c){var d,e,f,g;b.g=c;b.rb.style[E7]=c+F7;!!b.e&&(b.e.rb.style[E7]=c4,undefined);!!b.a&&(b.a.style[E7]=c4,undefined);g=sL(b);if(g>c){d=c;!!b.k&&(d-=JK(b.k));!!b.d&&(d-=JK(b.d));d<0&&(d=0);if(b.e){f=JK(b.e.rb);if(d>f){d-=f}else{b.e.rb.style[E7]=d+F7;d=0}}if(b.a){e=JK(b.a);d>e?(d-=e):(b.a.style[E7]=d+F7,undefined)}}}
function AW(b,c){var d,e;this.j=new UJ(0,0);this.t=new UJ(0,0);this.n=new UJ(0,0);this.a=(SO(),RO);this.k=Jd($doc,D4);this.s=Jd($doc,D4);if(NI((zI(),!yI&&(yI=new RI),zI(),yI))){e=Jd($doc,Z7);e.innerHTML=_qb;d=Fd(Fd(Fd(Fd(e))));e.cellPadding=0;e.cellSpacing=0;e.border=0;d.style[x9]=o6;this.rb=e;this.k=d}else{EW(this.s,T7);this.rb=this.k;this.k.style[G7]=o6;this.k.style[E7]=E8;this.k.style[S8]=M8}if((!yI&&(yI=new RI),yI).a.g){this.k.style[V7]=e9;this.s.style[V7]=e9}this.k.appendChild(this.s);c==1?EW(this.rb,T7):EW(this.rb,c4);this.rb.style[G7]=E8;this.j.e=0;this.j.f=0;this.o=0;this.k.style[Y8]=o6;this.k.style[Zqb]=o6;this.n.e=0;this.n.f=0;this.b=0;this.c=0;this.d=0;cW(this);sW(this,b)}
function uL(b,c){var d,e,f,g,i,k,n,o,p,q;b.rb.style.display=!Boolean(c[1][Fbb])?c4:N7;q=b.j;b.j=true;o=Kqb;if(Lbb in c[1]){p=tY(c[1][Lbb],B4,0);for(i=0;i<p.length;++i){o+=Lqb+p[i]}}W7 in c[1]&&(o+=Mqb);b.rb[H7]=o;f=kgb in c[1];g=rcb in c[1];e=Obb in c[1];n=Boolean(c[1][Qbb]);k=R6 in c[1]&&!Boolean(c[1][Nqb]);if(f){if(!b.e){b.e=new tP(b.c);b.e.rb.style[E7]=o6;b.e.rb.style[G7]=o6;Sw(b.rb,b.e.rb,qL(b,kgb))}b.j=false;b.f=false;sP(b.e,c[1][kgb])}else if(b.e){b.rb.removeChild(b.e.rb);b.e=null}if(g){if(!b.a){b.a=Jd($doc,D4);b.a.className=Oqb;Sw(b.rb,b.a,qL(b,rcb))}d=c[1][rcb];b.j=false;d==null||oY(vY(d),c4)?!f&&!n&&!k&&(b.a.innerHTML=wdb,undefined):(b.a.innerText=d||c4,undefined)}else if(b.a){b.rb.removeChild(b.a);b.a=null}e&&(b.a?xx(b,Ex(b.rb)+Pqb,true):xx(b,Ex(b.rb)+Pqb,false));if(n){if(!b.k){b.k=Jd($doc,D4);b.k.className=Qqb;b.k.innerText=Rqb;Sw(b.rb,b.k,qL(b,Qbb))}}else if(b.k){b.rb.removeChild(b.k);b.k=null}if(k){if(!b.d){b.d=Jd($doc,D4);b.d.innerHTML=wdb;b.d[H7]=$pb;Sw(b.rb,b.d,qL(b,R6))}}else if(b.d){b.rb.removeChild(b.d);b.d=null}if(!b.b){b.b=Jd($doc,D4);b.b.className=Sqb;b.rb.appendChild(b.b)}return q!=b.j}
var Lqb=' v-caption-',Mqb=' v-disabled',Rqb='*',Pqb='-hasdescription',lqb='1000000px',$qb='18px',_qb='<tbody><tr><td><div><\/div><\/td><\/tr><\/tbody>',brb='AlignmentInfo',frb='ChildComponentContainer',grb='ChildComponentContainer$ChildComponentContainerIterator',crb='Icon',drb='LayoutClickEventHandler',arb='VCaption',erb='VMarginInfo',Tqb='Warning: Icon load event was not propagated because VCaption owner is unknown.',xpb='alignments',Uqb='alt',zqb='com.vaadin.terminal.gwt.client.ui.layout.',Wqb='component',Yqb='containerHeight should never be negative: ',Xqb='containerWidth should never be negative: ',Jqb='cssFloat',ipb='end',Nqb='hideErrors',Cpb='layout_click',npb='margins',Zqb='paddingTop',upb='spacing',Iqb='styleFloat',Kqb='v-caption',Sqb='v-caption-clearelem',Oqb='v-captiontext',$pb='v-errorindicator',Vqb='v-icon',Qqb='v-required-field-indicator';_=SJ.prototype;_.Yc=function XJ(){return this.e};_.Zc=function YJ(){return this.f};_=vL.prototype=oL.prototype=new Uz;_.gC=function wL(){return Gp};_.Zb=function yL(b){var c,d;Qx(this,b);c=b.srcElement;!!this.c&&!!this.i&&c!=this.rb&&(rN(this.c.w,b,this.i),undefined);if(Lw(b.type)==32768&&this.e.rb==c&&!this.f){this.e.rb.style[E7]=c4;this.e.rb.style[G7]=c4;this.f=true;if(this.g!=-1){tL(this,this.g)}else{d=this.rb.style[E7];d!=null&&!oY(d,c4)&&(this.rb.style[E7]=sL(this)+F7,undefined)}this.i?PK(this.i,true):zL.Qc(Tqb)}};_.cM={9:1,12:1,13:1,20:1,58:1,74:1};_.a=null;_.b=null;_.c=null;_.d=null;_.e=null;_.f=false;_.g=-1;_.i=null;_.j=false;_.k=null;_=TO.prototype=QO.prototype=new J;_.gC=function UO(){return jq};_.cM={};_.a=0;var RO;_=tP.prototype=rP.prototype=new rx;_.gC=function uP(){return nq};_.cM={74:1};_.a=null;_.b=null;_=vP.prototype=new VO;_.cd=function wP(b){var c,d,e,f,g;d=this.c;g=Al(this.g,58).rb.tkPid;e=new CJ(b,WO(this));c=this.ed(b.srcElement);f=new i2;f.sd(vfb,c4+e.b+Xcb+e.c+Xcb+e.d+Xcb+e.a+Xcb+e.e+Xcb+e.f+Xcb+e.j+Xcb+e.k+Xcb+e.g+Xcb+e.i);f.sd(Wqb,c);tH(d,g,this.b,f)};_.gC=function xP(){return oq};_.cM={11:1,36:1,38:1,41:1};_=GR.prototype=FR.prototype=new J;_.eQ=function HR(b){if(!(b!=null&&b.cM&&!!b.cM[106])){return false}return Al(b,106).a==this.a};_.gC=function IR(){return Kq};_.hC=function JR(){return this.a};_.cM={27:1,106:1};_.a=0;_=AW.prototype=bW.prototype=new px;_.gC=function BW(){return rr};_.tc=function CW(){return new HW(this)};_.sc=function DW(b){return nW(this,b)};_.cM={9:1,12:1,13:1,18:1,19:1,20:1,30:1,58:1,71:1,74:1,104:1};_.b=0;_.c=0;_.d=0;_.e=null;_.f=0;_.g=0;_.i=0;_.k=null;_.o=0;_.p=0;_.q=null;_.r=null;_.s=null;_=HW.prototype=FW.prototype=new J;_.gC=function IW(){return qr};_.Wb=function JW(){return this.a<tW(this.b)};_.Xb=function KW(){var b;return b=GW(this,this.a),++this.a,b};_.Yb=function LW(){var b;b=this.a-1;if(b==0){if(this.b.r){nW(this.b,this.b.r)}else if(this.b.e){nW(this.b,this.b.e)}else{throw new FX}}else if(b==1){if(!!this.b.r&&!!this.b.e){nW(this.b,this.b.e)}else{throw new FX}}else{throw new FX}--this.a};_.cM={};_.a=0;_.b=null;_=tX.prototype=new J;_.cM={27:1,83:1};var Gp=mX(jmb,arb),jq=mX(lmb,brb),nq=mX(lmb,crb),oq=mX(lmb,drb),Kq=mX(lmb,erb),rr=mX(zqb,frb),qr=mX(zqb,grb);V3(Zb)();