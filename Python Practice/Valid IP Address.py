def ValidIP(IP):
  def valid_ipv4(group):
    try:
      return 0<=int(group)<=255 and str(int(group))==group
    except ValueError:
      return False
  def valid_ipv6(group):
    try:
      return 1<=len(group)<=4 and all(c in '123456789abcdefABCDEF' for c in group)
    except ValueError:
      return False
  if "." in IP:
    groups=IP.split(".")
    if len(group)!=4:
      return "Neither"
    for group in groups:
      if not valid_ipv4(group):
        return "Neither"
    return "IPv4"
  elif ":" in IP:
    groups=IP.split(":")
    if len(group)!=8:
      return "Neither"
    for group in groups:
      if not valid_ipv6(group):
        return "Neither"
    return "IPv6"
  else:
    return "Neither"

IP=input(" ")
print("output",ValidIP(IP))

"""
IPv4: 178.161.1.1
Neither : 256.256.256.256
IPv6: 2001:0db8:85a3:0:0:8A2E:0370:7334
"""

