var fs = require('fs'),
  fileDir = 'C:\\Users\\Zeigo\\Downloads\\',
  //fileInput = 'A-small-practice.in',
  fileInput = 'A-large-practice.in',
  //fileOut = 'A-small-practice.out',
  fileOut = 'A-large-practice.out',
  readable = fs.createReadStream(fileDir + fileInput, 'utf8'),
  input = '';

if (typeof String.prototype.endsWith !== 'function') {
  String.prototype.endsWith = function(suffix) {
    return this.indexOf(suffix, this.length - suffix.length) !== -1;
  };
}

readable.on('data', function(chunk) {
  input += chunk;
});

readable.on('end', function() {
  //console.log('Input received: '+ input);

  var inputLines = input.split('\n'),
    numOfTests = +inputLines[0],
    testSize = 3,
    output = '',
    writable = fs.createWriteStream(fileDir + fileOut, 'utf8');

  for (var test = 0; test < numOfTests; test++) {
    var vectorSize = +inputLines[(test * testSize) + 1],
      vectorX = inputLines[(test * testSize) + 2].split(' '),
      vectorY = inputLines[(test * testSize) + 3].split(' '),
      scalarProduct = 0;

    vectorX.sort(function(a,b) {return a - b;});
    vectorY.sort(function(a,b) {return b - a;});

    for (var elem = 0; elem < vectorSize; elem++) {
      scalarProduct += vectorX[elem] * vectorY[elem];
    }

    output += 'Case #' + (test + 1) + ': ' + scalarProduct + '\n';
  }

  writable.write(output, 'utf8');

});
