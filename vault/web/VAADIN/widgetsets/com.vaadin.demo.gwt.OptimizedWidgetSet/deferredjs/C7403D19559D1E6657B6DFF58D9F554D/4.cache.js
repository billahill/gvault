function dL(){}
function FO(){}
function gP(){}
function kP(){}
function uR(){}
function uW(){}
function SV(){}
function iX(){}
function Zb(){Ub(Mb)}
function Ub(b){Pb(b,b.f)}
function gy(b,c){Vx(c,b)}
function vR(b){this.b=b}
function wW(b){this.c=b}
function IO(b){HO();this.b=b}
function iW(b){return b.s?b.f?2:1:b.f?1:0}
function YV(b){if(!b.f){return 0}return b.g}
function _V(b){if(!b.f){return 0}return b.j}
function ZV(b){if(!b.f||b.f.k){return 0}return YV(b)}
function aW(b){if(!b.f||!b.f.k){return 0}return _V(b)}
function gW(b,c){b.p=c;b.n.style[k9]=c+b.e+(jg(),a5);mW(b)}
function nW(b){var c,d;d=yK(b.t);c=xK(b.t);b.u.g=d;b.u.f=c}
function lW(b){b.j=0;b.g=0;if(b.f){b.j=gL(b.f);b.g=eL(b.f);b.i=hL(b.f)}}
function pK(b){oK();b.attachEvent('onload',function(){rK(b)},false)}
function KG(b){var c;c=(zI(),!yI&&(yI=new RI),zI(),yI);c.b.i&&c.b.c==6&&pK(b)}
function KK(b,c){oK();(zI(),!yI&&(yI=new RI),zI(),yI).b.i?(b.style[g9]=c,undefined):(b.style[h9]=c,undefined)}
function dW(b,c,d,e){e<0&&(zI(),!yI&&(yI=new RI),zI(),yI).b.n&&(b.n.style[_4]=e9,undefined);Dl(b.s,24)._c(c,d)}
function jW(b,c,d){d==-1&&(d=b.k.ad());c==-1&&(c=b.k.bd());b.e=VV(b,d);UV(b,c);TV(b)}
function hW(b,c){if(c==b.s){return}!!c&&Tx(c);!!b.s&&cW(b,b.s);b.s=c;if(c){b.t.appendChild(b.s.sb);Vx(c,b)}}
function TV(b){gW(b,b.p);!!b.f&&(b.f.sb.style[l6]=b.c+(jg(),a5),undefined);b.t.style[l6]=b.d+(jg(),a5)}
function gL(b){var c;c=0;!!b.f&&(c+=yK(b.f.sb));!!b.b&&(c+=yK(b.b));!!b.n&&(c+=yK(b.n));!!b.e&&(c+=yK(b.e));return c}
function eL(b){var c,d;d=0;if(b.f){c=xK(b.f.sb);c>0&&(d=c)}if(b.b){c=xK(b.b);c>d&&(d=c)}if(b.n){c=xK(b.n);c>d&&(d=c)}if(b.e){c=xK(b.e);c>d&&(d=c)}return d}
function HO(){HO=H3;new IO(1);new IO(2);new IO(4);new IO(8);new IO(16);new IO(32);GO=new IO(5)}
function hP(b,c){var d;if(!dY(c,b.c)){Pv(b.sb,32768|(b.sb.__eventBits||0));d=nH(b.b,c);b.sb[o7]=d;b.c=c}}
function iP(b){this.sb=$doc.createElement(Q7);this.sb['alt']=M3;this.sb[c5]='v-icon';this.b=b;KG(this.sb)}
function Zw(b,c,d){var e=0,f=b.firstChild,g=null;while(f){if(f.nodeType==1){if(e==d){g=f;break}++e}f=f.nextSibling}b.insertBefore(c,g)}
function fL(b,c){var d;d=0;if(dY(c,_7)){return 0}!!b.f&&++d;if(dY(c,$6)){return d}!!b.b&&++d;if(dY(c,P6)){return d}!!b.n&&++d;return d}
function mL(b){if(b[1][$6]!=null){return true}if(S4 in b[1]){return true}if(_7 in b[1]){return true}if(P6 in b[1]){return true}return false}
function Pb(b,c){var d;d=c==b.f?R3:S3+c;!!$stats&&$stats(sc(d,Q8,c,-1));c<b.g.length&&wl(b.g,c,null);Tb(b,c)&&dc(b.i);b.b=-1;b.d[c]=true;Xb(b)}
function cW(b,c){if(c!=b.f&&c!=b.s){return false}Vx(c,null);if(c==b.f){b.n.removeChild(c.sb);b.f=null}else{b.t.removeChild(c.sb);b.s=null}return true}
function tW(b,c){if((zI(),!yI&&(yI=new RI),zI(),yI).b.i){b.style[g9]=c;dY(c,h5)?(b.style[Y5]=o6,undefined):(b.style[Y5]=Z5,undefined)}else{b.style[h9]=c}}
function eW(b,c){!!c&&Tx(c);!!b.f&&c!=b.f&&cW(b,b.f);b.f=c;if(b.f){if(b.f.k){KK(b.f.sb,h5);b.n.appendChild(b.f.sb)}else{KK(b.f.sb,M3);b.n.insertBefore(b.f.sb,b.t)}gy(b,b.f)}}
function GK(b){oK();var c,d,e,f,g,i;d=false;i=M3;c=M3;if(_4 in b[1]){d=true;i=b[1][_4]}if(b5 in b[1]){d=true;c=b[1][b5]}if(!d){return null}g=FK(i);e=FK(c);f=new FJ(g,e);return f}
function mW(b){var c,d;d=b.k.bd();c=b.k.ad()-b.e;d<0&&(d=0);c<0&&(c=0);b.sb.style[_4]=d+a5;b.sb.style[b5]=c+a5;if(b.f){b.f.k?iL(b.f,b.j):iL(b.f,d);b.j=gL(b.f);b.f.sb.style[b5]=M3}}
function vW(b,c){if(c==0){if(b.c.s){return b.c.s}else if(b.c.f){return b.c.f}else{throw new E3}}else if(c==1){if(!!b.c.s&&!!b.c.f){return b.c.f}else{throw new E3}}else{throw new E3}}
function hL(b){var c,d,e;e=0;!!b.f&&(e+=yK(b.f.sb));if(b.b){d=b.b.scrollWidth||0;if((zI(),!yI&&(yI=new RI),zI(),yI).b.f){c=yK(b.b);c>d&&(d=c)}e+=d}!!b.n&&(e+=yK(b.n));!!b.e&&(e+=yK(b.e));return e}
function kL(b,c){nA.call(this);this.d=c;this.j=b;!!c&&!!this.j&&(this.sb.vOwnerPid=Dl(this.j,58).sb.tkPid,undefined);this.sb[c5]=i9;this.pb==-1?Pv(this.sb,241|(this.sb.__eventBits||0)):(this.pb|=241)}
function VV(b,c){var d;if((b.b.b&4)==4){return 0}if(b.f){if(b.f.k){c-=RX(b.u.ad(),eL(b.f))}else{c-=b.u.ad();c-=YV(b)}}else{c-=b.u.ad()}d=0;(b.b.b&32)==32?(d=~~(c/2)):(b.b.b&8)==8&&(d=c);d<0&&(d=0);return d}
function fW(b,c,d){var e,f;f=c;f+=b.o.bd();e=d;e+=b.o.ad();if(f<0){oL.Uc('containerWidth should never be negative: '+f);f=0}if(e<0){oL.Uc('containerHeight should never be negative: '+e);e=0}b.k.g=f;b.k.f=e;mW(b)}
function kW(b,c,d){var e,f;if(mL(c)){e=b.f;if(!e){e=new kL(Dl(b.s,24),d);e.sb.style[b5]='18px';(zI(),!yI&&(yI=new RI),zI(),yI).b.i&&eW(b,e)}f=jL(e,c);(e!=b.f||f)&&eW(b,e)}else{!!b.f&&cW(b,b.f)}lW(b);!b.r&&(b.r=GK(c),undefined)}
function wK(b,c,d){var i,k;oK();var e,f,g;g=Dl(c,58).sb;while(!!d&&d!=g){f=(i=b.i[d.tkPid],!i?null:i.b);if(!f){e=d.vOwnerPid;e!=null&&(f=(k=b.i[e],!k?null:k.b))}if(f){while(!!d&&d!=g){d=Yd(d)}return d!=g?null:f}d=Yd(d)}return null}
function UV(b,c){var d,e;b.c=0;b.d=0;if((b.b.b&1)==1){return}d=c;e=c;if(b.f){if(b.f.k){d=0;e-=b.u.bd();e-=_V(b)}else{e-=b.u.bd();d-=_V(b)}}else{d=0;e-=b.u.bd()}if((b.b.b&16)==16){b.c=~~(d/2);b.d=~~(e/2)}else if((b.b.b&2)==2){b.c=d;b.d=e}b.c<0&&(b.c=0);b.d<0&&(b.d=0)}
function iL(b,c){var d,e,f,g;b.i=c;b.sb.style[_4]=c+a5;!!b.f&&(b.f.sb.style[_4]=M3,undefined);!!b.b&&(b.b.style[_4]=M3,undefined);g=hL(b);if(g>c){d=c;!!b.n&&(d-=yK(b.n));!!b.e&&(d-=yK(b.e));d<0&&(d=0);if(b.f){f=yK(b.f.sb);if(d>f){d-=f}else{b.f.sb.style[_4]=d+a5;d=0}}if(b.b){e=yK(b.b);d>e?(d-=e):(b.b.style[_4]=d+a5,undefined)}}}
function pW(b,c){var d,e;this.k=new JJ(0,0);this.u=new JJ(0,0);this.o=new JJ(0,0);this.b=(HO(),GO);this.n=$doc.createElement(u5);this.t=$doc.createElement(u5);if(NI((zI(),!yI&&(yI=new RI),zI(),yI))){e=$doc.createElement(n5);e.innerHTML='<tbody><tr><td><div><\/div><\/td><\/tr><\/tbody>';d=Xd(Xd(Xd(Xd(e))));e.cellPadding=0;e.cellSpacing=0;e.border=0;d.style[n6]=C4;this.sb=e;this.n=d}else{tW(this.t,h5);this.sb=this.n;this.n.style[b5]=C4;this.n.style[_4]=Q5;this.n.style[$5]=V5}if((!yI&&(yI=new RI),yI).b.i){this.n.style[b4]=d6;this.t.style[b4]=d6}this.n.appendChild(this.t);c==1?tW(this.sb,h5):tW(this.sb,M3);this.sb.style[b5]=Q5;this.k.f=0;this.k.g=0;this.p=0;this.n.style[a6]=C4;this.n.style[k9]=C4;this.o.f=0;this.o.g=0;this.c=0;this.d=0;this.e=0;TV(this);hW(this,b)}
function jL(b,c){var d,e,f,g,i,k,n,o,p,q;b.sb.style.display=!Boolean(c[1][I6])?M3:g5;q=b.k;b.k=true;o=i9;if(N6 in c[1]){p=hY(c[1][N6],_3,0);for(i=0;i<p.length;++i){o+=' v-caption-'+p[i]}}j5 in c[1]&&(o+=' v-disabled');b.sb[c5]=o;f=_7 in c[1];g=$6 in c[1];e=O6 in c[1];n=Boolean(c[1][P6]);k=S4 in c[1]&&!Boolean(c[1]['hideErrors']);if(f){if(!b.f){b.f=new iP(b.d);b.f.sb.style[_4]=C4;b.f.sb.style[b5]=C4;Zw(b.sb,b.f.sb,fL(b,_7))}b.k=false;b.g=false;hP(b.f,c[1][_7])}else if(b.f){b.sb.removeChild(b.f.sb);b.f=null}if(g){if(!b.b){b.b=$doc.createElement(u5);b.b.className='v-captiontext';Zw(b.sb,b.b,fL(b,$6))}d=c[1][$6];b.k=false;d==null||dY(jY(d),M3)?!f&&!n&&!k&&(b.b.innerHTML=t7,undefined):(b.b.textContent=d||M3,undefined)}else if(b.b){b.sb.removeChild(b.b);b.b=null}e&&(b.b?yx(b,Fx(b.sb)+j9,true):yx(b,Fx(b.sb)+j9,false));if(n){if(!b.n){b.n=$doc.createElement(u5);b.n.className='v-required-field-indicator';b.n.textContent='*';Zw(b.sb,b.n,fL(b,P6))}}else if(b.n){b.sb.removeChild(b.n);b.n=null}if(k){if(!b.e){b.e=$doc.createElement(u5);b.e.innerHTML=t7;b.e[c5]=b9;Zw(b.sb,b.e,fL(b,S4))}}else if(b.e){b.sb.removeChild(b.e);b.e=null}if(!b.c){b.c=$doc.createElement(u5);b.c.className='v-caption-clearelem';b.sb.appendChild(b.c)}return q!=b.k}
var j9='-hasdescription',e9='1000000px',X8='alignments',f9='com.vaadin.terminal.gwt.client.ui.layout.',h9='cssFloat',Q8='end',Y8='layout_click',T8='margins',k9='paddingTop',U8='spacing',g9='styleFloat',i9='v-caption',b9='v-errorindicator';_=HJ.prototype;_.ad=function MJ(){return this.f};_.bd=function NJ(){return this.g};_=kL.prototype=dL.prototype=new eA;_.gC=function lL(){return Lp};_.bc=function nL(b){var c,d;Rx(this,b);c=b.target;!!this.d&&!!this.j&&c!=this.sb&&(gN(this.d.x,b,this.j),undefined);if(Ow(b.type)==32768&&this.f.sb==c&&!this.g){this.f.sb.style[_4]=M3;this.f.sb.style[b5]=M3;this.g=true;if(this.i!=-1){iL(this,this.i)}else{d=this.sb.style[_4];d!=null&&!dY(d,M3)&&(this.sb.style[_4]=hL(this)+a5,undefined)}this.j?EK(this.j,true):oL.Uc('Warning: Icon load event was not propagated because VCaption owner is unknown.')}};_.cM={9:1,12:1,13:1,20:1,58:1,74:1};_.b=null;_.c=null;_.d=null;_.e=null;_.f=null;_.g=false;_.i=-1;_.j=null;_.k=false;_.n=null;_=IO.prototype=FO.prototype=new J;_.gC=function JO(){return oq};_.cM={};_.b=0;var GO;_=iP.prototype=gP.prototype=new sx;_.gC=function jP(){return sq};_.cM={74:1};_.b=null;_.c=null;_=kP.prototype=new KO;_.gd=function lP(b){var c,d,e,f,g;d=this.d;g=Dl(this.i,58).sb.tkPid;e=new rJ(b,LO(this));c=this.jd(b.target);f=new Y1;f.wd(O7,M3+e.c+j7+e.d+j7+e.e+j7+e.b+j7+e.f+j7+e.g+j7+e.k+j7+e.n+j7+e.i+j7+e.j);f.wd('component',c);tH(d,g,this.c,f)};_.gC=function mP(){return tq};_.cM={11:1,36:1,38:1,41:1};_=vR.prototype=uR.prototype=new J;_.eQ=function wR(b){if(!(b!=null&&b.cM&&!!b.cM[106])){return false}return Dl(b,106).b==this.b};_.gC=function xR(){return Pq};_.hC=function yR(){return this.b};_.cM={27:1,106:1};_.b=0;_=pW.prototype=SV.prototype=new qx;_.gC=function qW(){return wr};_.vc=function rW(){return new wW(this)};_.uc=function sW(b){return cW(this,b)};_.cM={9:1,12:1,13:1,18:1,19:1,20:1,30:1,58:1,71:1,74:1,104:1};_.c=0;_.d=0;_.e=0;_.f=null;_.g=0;_.i=0;_.j=0;_.n=null;_.p=0;_.q=0;_.r=null;_.s=null;_.t=null;_=wW.prototype=uW.prototype=new J;_.gC=function xW(){return vr};_.$b=function yW(){return this.b<iW(this.c)};_._b=function zW(){var b;return b=vW(this,this.b),++this.b,b};_.ac=function AW(){var b;b=this.b-1;if(b==0){if(this.c.s){cW(this.c,this.c.s)}else if(this.c.f){cW(this.c,this.c.f)}else{throw new uX}}else if(b==1){if(!!this.c.s&&!!this.c.f){cW(this.c,this.c.f)}else{throw new uX}}else{throw new uX}--this.b};_.cM={};_.b=0;_.c=null;_=iX.prototype=new J;_.cM={27:1,83:1};var Lp=bX(L8,'VCaption'),oq=bX(M8,'AlignmentInfo'),sq=bX(M8,'Icon'),tq=bX(M8,'LayoutClickEventHandler'),Pq=bX(M8,'VMarginInfo'),wr=bX(f9,'ChildComponentContainer'),vr=bX(f9,'ChildComponentContainer$ChildComponentContainerIterator');J3(Zb)();