/etc/nginx/sites-enabled/team1:
  file.managed:
    - user: root
    - group: root
    - makedirs: True
    - source: salt://apps/team1/files/nginx/team1
    - template: jinja

team1-nginx-reload:
  service.running:
    - name: nginx
    - enable: True
    - reload: True
    - watch:
      - file: /etc/nginx/sites-enabled/*