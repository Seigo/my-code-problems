var fs = require('fs'),
  inputFile = 'B-large-practice.in',
  outputFile = 'B-large-practice.out',
  readStream = fs
    .createReadStream('C:\\Users\\Zeigo\\Downloads\\' + inputFile,
      {encoding: 'utf8'}),
  inputLines = '';

if (typeof String.prototype.endsWith !== 'function') {
  String.prototype.endsWith = function(suffix) {
    return this.indexOf(suffix, this.length - suffix.length) !== -1;
  };
}

readStream.on('data', function(chunk) {
  console.log('Reading input: \n' + chunk);
  inputLines += chunk;
});

readStream.on('end', function() {
  var lines = inputLines.split("\n"),
    outputLines = '';

  numOfTests = +lines[0];
  console.log(typeof numOfTests + ' numOfTests: ' + numOfTests);

  for (var i = 1; i < numOfTests + 1; i++) {
    if (lines[i].length == 0) {
      continue;
    }
    splitLine = lines[i].split(' ');
    for (var j = splitLine.length - 1; j > -1; j--) {
      if (outputLines.length == 0 || outputLines.endsWith('\n')) {
        outputLines += 'Case #' + i + ': ';
      } else {
        outputLines += ' ';
      }
      outputLines += splitLine[j];
    }
    outputLines += '\n';
  }
  console.log('Output:\n' + outputLines);

  writeable = fs
    .createWriteStream('C:\\Users\\Zeigo\\Downloads\\' + outputFile,
      {encoding: 'utf8'});
  writeable.write(outputLines, 'utf8', function(a,b,c) {
    console.log('Writing finished with '+ a +', '+ b +', '+ c +'!');
  });
});
