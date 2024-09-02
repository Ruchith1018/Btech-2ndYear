% Encryption and Decryption using Fourier matrices

try
    % Load the input data (plaintext)
    plaintext = 'Hello, World!';

    % Convert the plaintext to ASCII values
    plaintextASCII = double(plaintext);

    % Perform the Fourier transform on the ASCII values
    transformedData = fft(plaintextASCII);

    % Generate a random key (encryption key)
    key = randn(size(transformedData));

    % Encrypt the transformed data using element-wise multiplication with the key
    encryptedData = transformedData .* key;

    % Decryption

    % Decrypt the encrypted data using element-wise division with the key
    decryptedData = encryptedData ./ key;

    % Perform the inverse Fourier transform to obtain the original ASCII values
    recoveredASCII = ifft(decryptedData);

    % Convert the ASCII values back to plaintext
    recoveredPlaintext = char(round(real(recoveredASCII)));

    % Display the results
    disp('Plaintext:');
    disp(plaintext);
    disp('Recovered Plaintext:');
    disp(recoveredPlaintext);
    disp(encryptedData)
    disp(key)
    disp(transformedData)
catch exception
    % Display any errors that occur during execution
    disp('An error occurred:');
    disp(exception.message);
end

