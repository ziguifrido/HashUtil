![GitHub](https://img.shields.io/github/license/ziguifrido/HashUtil)
![GitHub top language](https://img.shields.io/github/languages/top/ziguifrido/HashUtil)
![GitHub last commit](https://img.shields.io/github/last-commit/ziguifrido/HashUtil)


# HashUtil
#### A simple hash library for Java

With HashUtil you can generate and validate MD5, SHA-1, SHA-256 and SHA-512 hashes.


## Example

* To generate the MD5 hash from the key `"MyKey"` you can use 


```java
  String hash = HashUtil.md5("MyKey");
```

and the return will be `3d7d052a031e864ee9c1b04b5a4d0f11`.

* To validate the same hash you can use 

```java
  Boolean isValid = HashUtil.validateMD5("MyKey", "3d7d052a031e864ee9c1b04b5a4d0f11")
```

and the return will be `true`.

## Warning

Be aware that simply using the password hash as security validation is **not** secure.

## Licence
This projet uses the [MIT license](https://github.com/ziguifrido/HashUtil/blob/master/LICENSE.md).
