base:
  '*':
    - zip
    - nginx

  'G@role:team1':
    - match: compound
    - java
    - apps.team1
