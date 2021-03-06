# A simple hash library for Java

With HashUtil you can generate and validate MD5, SHA-1, SHA-256 and SHA-512 hashes.


## Example

* To generate the MD5 hash from the key `"MyKey"` you can use 

>`String hash = HashUtil.md5("MyKey");` 

and the return will: `3d7d052a031e864ee9c1b04b5a4d0f11`.

* To validate the same hash you can use 

>`Boolean isValid = HashUtil.validateMD5("MyKey", "3d7d052a031e864ee9c1b04b5a4d0f11")` 

and the return will be `true`.

#### Warning

Be aware that simply use password's hash as security validation is **not** safe.
