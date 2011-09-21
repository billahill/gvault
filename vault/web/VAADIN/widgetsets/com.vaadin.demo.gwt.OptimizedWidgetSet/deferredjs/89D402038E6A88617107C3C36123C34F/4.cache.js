function GK(){}
function gO(){}
function JO(){}
function NO(){}
function XQ(){}
function XV(){}
function tV(){}
function LW(){}
function Zb(){Ub(Mb)}
function Ub(b){Pb(b,b.f)}
function Sx(b,c){Fx(c,b)}
function YQ(b){this.b=b}
function ZV(b){this.c=b}
function jO(b){iO();this.b=b}
function LV(b){return b.s?b.f?2:1:b.f?1:0}
function zV(b){if(!b.f){return 0}return b.g}
function CV(b){if(!b.f){return 0}return b.j}
function AV(b){if(!b.f||b.f.k){return 0}return zV(b)}
function DV(b){if(!b.f||!b.f.k){return 0}return CV(b)}
function JV(b,c){b.p=c;b.n.style[M8]=c+b.e+(Xf(),A4);PV(b)}
function QV(b){var c,d;d=_J(b.t);c=$J(b.t);b.u.g=d;b.u.f=c}
function OV(b){b.j=0;b.g=0;if(b.f){b.j=JK(b.f);b.g=HK(b.f);b.i=KK(b.f)}}
function SJ(b){RJ();b.attachEvent('onload',function(){UJ(b)},false)}
function lG(b){var c;c=(aI(),!_H&&(_H=new sI),aI(),_H);c.b.i&&c.b.c==6&&SJ(b)}
function lK(b,c){RJ();(aI(),!_H&&(_H=new sI),aI(),_H).b.i?(b.style[I8]=c,undefined):(b.style[J8]=c,undefined)}
function GV(b,c,d,e){e<0&&(aI(),!_H&&(_H=new sI),aI(),_H).b.n&&(b.n.style[z4]=G8,undefined);pl(b.s,24).Vc(c,d)}
function MV(b,c,d){d==-1&&(d=b.k.Wc());c==-1&&(c=b.k.Xc());b.e=wV(b,d);vV(b,c);uV(b)}
function KV(b,c){if(c==b.s){return}!!c&&Dx(c);!!b.s&&FV(b,b.s);b.s=c;if(c){b.t.appendChild(b.s.sb);Fx(c,b)}}
function uV(b){JV(b,b.p);!!b.f&&(b.f.sb.style[L5]=b.c+(Xf(),A4),undefined);b.t.style[L5]=b.d+(Xf(),A4)}
function JK(b){var c;c=0;!!b.f&&(c+=_J(b.f.sb));!!b.b&&(c+=_J(b.b));!!b.n&&(c+=_J(b.n));!!b.e&&(c+=_J(b.e));return c}
function HK(b){var c,d;d=0;if(b.f){c=$J(b.f.sb);c>0&&(d=c)}if(b.b){c=$J(b.b);c>d&&(d=c)}if(b.n){c=$J(b.n);c>d&&(d=c)}if(b.e){c=$J(b.e);c>d&&(d=c)}return d}
function iO(){iO=i3;new jO(1);new jO(2);new jO(4);new jO(8);new jO(16);new jO(32);hO=new jO(5)}
function KO(b,c){var d;if(!GX(c,b.c)){Jw(b.sb,32768|(b.sb.__eventBits||0));d=QG(b.b,c);b.sb[Q6]=d;b.c=c}}
function LO(b){this.sb=$doc.createElement(q7);this.sb['alt']=n3;this.sb[C4]='v-icon';this.b=b;lG(this.sb)}
function Gw(b,c,d){var e=0,f=b.firstChild,g=null;while(f){if(f.nodeType==1){if(e==d){g=f;break}++e}f=f.nextSibling}b.insertBefore(c,g)}
function IK(b,c){var d;d=0;if(GX(c,B7)){return 0}!!b.f&&++d;if(GX(c,z6)){return d}!!b.b&&++d;if(GX(c,o6)){return d}!!b.n&&++d;return d}
function PK(b){if(b[1][z6]!=null){return true}if(p4 in b[1]){return true}if(B7 in b[1]){return true}if(o6 in b[1]){return true}return false}
function Pb(b,c){var d;d=c==b.f?s3:t3+c;!!$stats&&$stats(sc(d,q8,c,-1));c<b.g.length&&il(b.g,c,null);Tb(b,c)&&dc(b.i);b.b=-1;b.d[c]=true;Xb(b)}
function FV(b,c){if(c!=b.f&&c!=b.s){return false}Fx(c,null);if(c==b.f){b.n.removeChild(c.sb);b.f=null}else{b.t.removeChild(c.sb);b.s=null}return true}
function WV(b,c){if((aI(),!_H&&(_H=new sI),aI(),_H).b.i){b.style[I8]=c;GX(c,H4)?(b.style[v5]=O5,undefined):(b.style[v5]=w5,undefined)}else{b.style[J8]=c}}
function HV(b,c){!!c&&Dx(c);!!b.f&&c!=b.f&&FV(b,b.f);b.f=c;if(b.f){if(b.f.k){lK(b.f.sb,H4);b.n.appendChild(b.f.sb)}else{lK(b.f.sb,n3);b.n.insertBefore(b.f.sb,b.t)}Sx(b,b.f)}}
function hK(b){RJ();var c,d,e,f,g,i;d=false;i=n3;c=n3;if(z4 in b[1]){d=true;i=b[1][z4]}if(B4 in b[1]){d=true;c=b[1][B4]}if(!d){return null}g=gK(i);e=gK(c);f=new gJ(g,e);return f}
function PV(b){var c,d;d=b.k.Xc();c=b.k.Wc()-b.e;d<0&&(d=0);c<0&&(c=0);b.sb.style[z4]=d+A4;b.sb.style[B4]=c+A4;if(b.f){b.f.k?LK(b.f,b.j):LK(b.f,d);b.j=JK(b.f);b.f.sb.style[B4]=n3}}
function YV(b,c){if(c==0){if(b.c.s){return b.c.s}else if(b.c.f){return b.c.f}else{throw new f3}}else if(c==1){if(!!b.c.s&&!!b.c.f){return b.c.f}else{throw new f3}}else{throw new f3}}
function KK(b){var c,d,e;e=0;!!b.f&&(e+=_J(b.f.sb));if(b.b){d=b.b.scrollWidth||0;if((aI(),!_H&&(_H=new sI),aI(),_H).b.f){c=_J(b.b);c>d&&(d=c)}e+=d}!!b.n&&(e+=_J(b.n));!!b.e&&(e+=_J(b.e));return e}
function NK(b,c){Oz.call(this);this.d=c;this.j=b;!!c&&!!this.j&&(this.sb.vOwnerPid=pl(this.j,58).sb.tkPid,undefined);this.sb[C4]=K8;this.pb==-1?Jw(this.sb,241|(this.sb.__eventBits||0)):(this.pb|=241)}
function wV(b,c){var d;if((b.b.b&4)==4){return 0}if(b.f){if(b.f.k){c-=sX(b.u.Wc(),HK(b.f))}else{c-=b.u.Wc();c-=zV(b)}}else{c-=b.u.Wc()}d=0;(b.b.b&32)==32?(d=~~(c/2)):(b.b.b&8)==8&&(d=c);d<0&&(d=0);return d}
function IV(b,c,d){var e,f;f=c;f+=b.o.Xc();e=d;e+=b.o.Wc();if(f<0){RK.Oc('containerWidth should never be negative: '+f);f=0}if(e<0){RK.Oc('containerHeight should never be negative: '+e);e=0}b.k.g=f;b.k.f=e;PV(b)}
function NV(b,c,d){var e,f;if(PK(c)){e=b.f;if(!e){e=new NK(pl(b.s,24),d);e.sb.style[B4]='18px';(aI(),!_H&&(_H=new sI),aI(),_H).b.i&&HV(b,e)}f=MK(e,c);(e!=b.f||f)&&HV(b,e)}else{!!b.f&&FV(b,b.f)}OV(b);!b.r&&(b.r=hK(c),undefined)}
function ZJ(b,c,d){var i,k;RJ();var e,f,g;g=pl(c,58).sb;while(!!d&&d!=g){f=(i=b.i[d.tkPid],!i?null:i.b);if(!f){e=d.vOwnerPid;e!=null&&(f=(k=b.i[e],!k?null:k.b))}if(f){while(!!d&&d!=g){d=Ed(d)}return d!=g?null:f}d=Ed(d)}return null}
function vV(b,c){var d,e;b.c=0;b.d=0;if((b.b.b&1)==1){return}d=c;e=c;if(b.f){if(b.f.k){d=0;e-=b.u.Xc();e-=CV(b)}else{e-=b.u.Xc();d-=CV(b)}}else{d=0;e-=b.u.Xc()}if((b.b.b&16)==16){b.c=~~(d/2);b.d=~~(e/2)}else if((b.b.b&2)==2){b.c=d;b.d=e}b.c<0&&(b.c=0);b.d<0&&(b.d=0)}
function LK(b,c){var d,e,f,g;b.i=c;b.sb.style[z4]=c+A4;!!b.f&&(b.f.sb.style[z4]=n3,undefined);!!b.b&&(b.b.style[z4]=n3,undefined);g=KK(b);if(g>c){d=c;!!b.n&&(d-=_J(b.n));!!b.e&&(d-=_J(b.e));d<0&&(d=0);if(b.f){f=_J(b.f.sb);if(d>f){d-=f}else{b.f.sb.style[z4]=d+A4;d=0}}if(b.b){e=_J(b.b);d>e?(d-=e):(b.b.style[z4]=d+A4,undefined)}}}
function SV(b,c){var d,e;this.k=new kJ(0,0);this.u=new kJ(0,0);this.o=new kJ(0,0);this.b=(iO(),hO);this.n=$doc.createElement(U4);this.t=$doc.createElement(U4);if(oI((aI(),!_H&&(_H=new sI),aI(),_H))){e=$doc.createElement(N4);e.innerHTML='<tbody><tr><td><div><\/div><\/td><\/tr><\/tbody>';d=Dd(Dd(Dd(Dd(e))));e.cellPadding=0;e.cellSpacing=0;e.border=0;d.style[N5]=Z3;this.sb=e;this.n=d}else{WV(this.t,H4);this.sb=this.n;this.n.style[B4]=Z3;this.n.style[z4]=o5;this.n.style[x5]=s5}if((!_H&&(_H=new sI),_H).b.i){this.n.style[J4]=D5;this.t.style[J4]=D5}this.n.appendChild(this.t);c==1?WV(this.sb,H4):WV(this.sb,n3);this.sb.style[B4]=o5;this.k.f=0;this.k.g=0;this.p=0;this.n.style[A5]=Z3;this.n.style[M8]=Z3;this.o.f=0;this.o.g=0;this.c=0;this.d=0;this.e=0;uV(this);KV(this,b)}
function MK(b,c){var d,e,f,g,i,k,n,o,p,q;b.sb.style.display=!Boolean(c[1][h6])?n3:G4;q=b.k;b.k=true;o=K8;if(m6 in c[1]){p=KX(c[1][m6],z3,0);for(i=0;i<p.length;++i){o+=' v-caption-'+p[i]}}K4 in c[1]&&(o+=' v-disabled');b.sb[C4]=o;f=B7 in c[1];g=z6 in c[1];e=n6 in c[1];n=Boolean(c[1][o6]);k=p4 in c[1]&&!Boolean(c[1]['hideErrors']);if(f){if(!b.f){b.f=new LO(b.d);b.f.sb.style[z4]=Z3;b.f.sb.style[B4]=Z3;Gw(b.sb,b.f.sb,IK(b,B7))}b.k=false;b.g=false;KO(b.f,c[1][B7])}else if(b.f){b.sb.removeChild(b.f.sb);b.f=null}if(g){if(!b.b){b.b=$doc.createElement(U4);b.b.className='v-captiontext';Gw(b.sb,b.b,IK(b,z6))}d=c[1][z6];b.k=false;d==null||GX(MX(d),n3)?!f&&!n&&!k&&(b.b.innerHTML=V6,undefined):(b.b.textContent=d||n3,undefined)}else if(b.b){b.sb.removeChild(b.b);b.b=null}e&&(b.b?ix(b,px(b.sb)+L8,true):ix(b,px(b.sb)+L8,false));if(n){if(!b.n){b.n=$doc.createElement(U4);b.n.className='v-required-field-indicator';b.n.textContent='*';Gw(b.sb,b.n,IK(b,o6))}}else if(b.n){b.sb.removeChild(b.n);b.n=null}if(k){if(!b.e){b.e=$doc.createElement(U4);b.e.innerHTML=V6;b.e[C4]=D8;Gw(b.sb,b.e,IK(b,p4))}}else if(b.e){b.sb.removeChild(b.e);b.e=null}if(!b.c){b.c=$doc.createElement(U4);b.c.className='v-caption-clearelem';b.sb.appendChild(b.c)}return q!=b.k}
var L8='-hasdescription',G8='1000000px',x8='alignments',H8='com.vaadin.terminal.gwt.client.ui.layout.',J8='cssFloat',q8='end',y8='layout_click',t8='margins',M8='paddingTop',u8='spacing',I8='styleFloat',K8='v-caption',D8='v-errorindicator';_=iJ.prototype;_.Wc=function nJ(){return this.f};_.Xc=function oJ(){return this.g};_=NK.prototype=GK.prototype=new Fz;_.gC=function OK(){return sp};_.Zb=function QK(b){var c,d;Bx(this,b);c=b.target;!!this.d&&!!this.j&&c!=this.sb&&(JM(this.d.x,b,this.j),undefined);if(vw(b.type)==32768&&this.f.sb==c&&!this.g){this.f.sb.style[z4]=n3;this.f.sb.style[B4]=n3;this.g=true;if(this.i!=-1){LK(this,this.i)}else{d=this.sb.style[z4];d!=null&&!GX(d,n3)&&(this.sb.style[z4]=KK(this)+A4,undefined)}this.j?fK(this.j,true):RK.Oc('Warning: Icon load event was not propagated because VCaption owner is unknown.')}};_.cM={9:1,12:1,13:1,20:1,58:1,74:1};_.b=null;_.c=null;_.d=null;_.e=null;_.f=null;_.g=false;_.i=-1;_.j=null;_.k=false;_.n=null;_=jO.prototype=gO.prototype=new J;_.gC=function kO(){return Xp};_.cM={};_.b=0;var hO;_=LO.prototype=JO.prototype=new cx;_.gC=function MO(){return _p};_.cM={74:1};_.b=null;_.c=null;_=NO.prototype=new lO;_.ad=function OO(b){var c,d,e,f,g;d=this.d;g=pl(this.i,58).sb.tkPid;e=new UI(b,mO(this));c=this.cd(b.target);f=new z1;f.qd(o7,n3+e.c+L6+e.d+L6+e.e+L6+e.b+L6+e.f+L6+e.g+L6+e.k+L6+e.n+L6+e.i+L6+e.j);f.qd('component',c);WG(d,g,this.c,f)};_.gC=function PO(){return aq};_.cM={11:1,36:1,38:1,41:1};_=YQ.prototype=XQ.prototype=new J;_.eQ=function ZQ(b){if(!(b!=null&&b.cM&&!!b.cM[106])){return false}return pl(b,106).b==this.b};_.gC=function $Q(){return wq};_.hC=function _Q(){return this.b};_.cM={27:1,106:1};_.b=0;_=SV.prototype=tV.prototype=new ax;_.gC=function TV(){return dr};_.rc=function UV(){return new ZV(this)};_.qc=function VV(b){return FV(this,b)};_.cM={9:1,12:1,13:1,18:1,19:1,20:1,30:1,58:1,71:1,74:1,104:1};_.c=0;_.d=0;_.e=0;_.f=null;_.g=0;_.i=0;_.j=0;_.n=null;_.p=0;_.q=0;_.r=null;_.s=null;_.t=null;_=ZV.prototype=XV.prototype=new J;_.gC=function $V(){return cr};_.Wb=function _V(){return this.b<LV(this.c)};_.Xb=function aW(){var b;return b=YV(this,this.b),++this.b,b};_.Yb=function bW(){var b;b=this.b-1;if(b==0){if(this.c.s){FV(this.c,this.c.s)}else if(this.c.f){FV(this.c,this.c.f)}else{throw new XW}}else if(b==1){if(!!this.c.s&&!!this.c.f){FV(this.c,this.c.f)}else{throw new XW}}else{throw new XW}--this.b};_.cM={};_.b=0;_.c=null;_=LW.prototype=new J;_.cM={27:1,83:1};var sp=EW(l8,'VCaption'),Xp=EW(m8,'AlignmentInfo'),_p=EW(m8,'Icon'),aq=EW(m8,'LayoutClickEventHandler'),wq=EW(m8,'VMarginInfo'),dr=EW(H8,'ChildComponentContainer'),cr=EW(H8,'ChildComponentContainer$ChildComponentContainerIterator');k3(Zb)();