addEvent(window, 'load',initialize);
addEvent(document,'mouseup',showCharCode);
function initialize()
{
if(document.getElementById)
{
var oButton=document.getElementById('showstr');
if(oButton)
{
addEvent(oButton,'click',showString);
}
}
}
function showString()
{
var oEntry1=document.getElementById('entry1');
var oEntry2=document.getElementById('entry2');
var oEntry3=document.getElementById('entry3');
var oResult=document.getElementById('result');
oResult.value=String.fromCharCode(oEntry1.value,oEntry2.value,oEntry3.value);

}

function showCharCode()
{
var theText="";
var oDisplay=document.getElementById('display');
if(window.getSelection)
{

theText=window.getSelection.toString();
}
else if(document.getSelection)
{

theText=document.getSelection();
}
else if(document.selection && document.selection.createRange)
{
theText=document.selection.createRange().Text;
}
if(theText)
{
oDisplay.value=theText.charCodeAt();
}
else
{
oDisplay.value=" ";
}
}